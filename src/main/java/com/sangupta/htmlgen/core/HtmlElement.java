/**
 *
 * html-gen - HTML generation library
 * Copyright (c) 2014-2015, Sandeep Gupta
 * 
 * http://sangupta.com/projects/htmlgen
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.sangupta.htmlgen.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sangupta.htmlgen.HtmlBody;
import com.sangupta.htmlgen.tags.Text;
import com.sangupta.htmlgen.tags.body.Div;
import com.sangupta.htmlgen.tags.body.Span;

/**
 * 
 * @author sangupta
 *
 */
public class HtmlElement<T> implements HtmlNode {
	
	protected final Set<HtmlAttribute> attributes = new HashSet<HtmlAttribute>();
	
	protected final List<HtmlElement<?>> children = new ArrayList<HtmlElement<?>>();
	
	protected HtmlNode parent;
	
	protected final String name;
	
	protected final Class<T> clazzOfT;
	
	public HtmlElement(String name, Class<T> clazzOfT) {
		this.name = name.toLowerCase();
		this.clazzOfT = clazzOfT;
	}
	
	public HtmlNode parent() {
		return this.parent;
	}
	
	public <X extends HtmlNode> X parent(Class<X> clazz) {
		HtmlNode parent = this.parent;
		do {
			if(parent == null) {
				return null;
			}
			
			if(parent.getClass().equals(clazz)) {
				return clazz.cast(parent);
			}
			
			parent = parent.parent();
		} while(true);
	}
	
	/**
	 * Return the nearest <code>BODY</code> element in the ancestor hierarchy.
	 * 
	 * @return
	 */
	public HtmlBody parentBody() {
		return parent(HtmlBody.class);
	}
	
	/**
	 * Return the nearest <code>DIV</code> element in the ancestor hierarchy.
	 * 
	 * @return
	 */
	public Div parentDiv() {
		return parent(Div.class);
	}
	
	/**
	 * Return the nearest <code>SPAN</code> element in the ancestor hierarchy.
	 * 
	 * @return
	 */
	public Span parentSpan() {
		return parent(Span.class);
	}
	
	public T parent(HtmlNode parent) {
		this.parent = parent;
		return clazzOfT.cast(this);
	}

	/**
	 * Add the given attribute to the element.
	 * 
	 * @param attribute
	 */
	public void addAttribute(HtmlAttribute attribute) {
		this.attributes.add(attribute);
	}
	
	/**
	 * Add an attribute by the given name and value to the element.
	 * 
	 * @param name
	 * @param value
	 * @return
	 */
	public T attr(String name, String value) {
		this.attributes.add(new HtmlAttribute(name, value));
		return clazzOfT.cast(this);
	}
	
	public T text(String text) {
		this.addChild(new Text(text));
		return clazzOfT.cast(this);
	}
	
	protected T addChild(HtmlElement<?> child) {
		this.children.add(child);
		return clazzOfT.cast(this);
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		if(this == obj) {
			return true;
		}
		
		if(obj instanceof String) {
			return this.name.equalsIgnoreCase((String) obj);
		}
		
		if(!(obj instanceof HtmlElement)) {
			return false;
		}
		
		return this.name.equals(((HtmlElement<?>) obj).name);
	}
	
	/**
	 * Remove all child elements, attributes, and text content from this element.
	 * 
	 */
	public void clear() {
		this.attributes.clear();
		this.children.clear();
	}
	
	public void build(StringBuilder builder, int indentLevel) {
		indent(builder, indentLevel);
		builder.append("<");
		builder.append(this.name);
		
		// check for attributes
		if(!this.attributes.isEmpty()) {
			for(HtmlAttribute attribute : this.attributes) {
				builder.append(' ');
				builder.append(attribute.name);
				builder.append("='");
				builder.append(attribute.value);
				builder.append("'");
			}
		}
		
		// any custom attributes
		outCustomAttributes(builder);
		
		// close the starting tag
		builder.append('>');
		
		// for children
		if(!this.children.isEmpty()) {
			for(HtmlElement<?> child : this.children) {
				if(child instanceof Text) {
					Text ele = (Text) child;
					String text = ele.text();
					if(text != null) {
						indent(builder, indentLevel + 1);
						builder.append(text);
					}
				} else {
					child.build(builder, indentLevel + 1);
				}
			}
		}
		
		// close up
		indent(builder, indentLevel);
		builder.append("</");
		builder.append(this.name);
		builder.append('>');
	}
	
	protected void outCustomAttributes(StringBuilder builder) {
		
	}
	
	protected void indent(StringBuilder builder, int level) {
		builder.append('\n');
		for(int i = 0; i < level; i++) {
			builder.append("  ");
		}
	}
}