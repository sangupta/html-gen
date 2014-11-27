/**
 *
 * html-gen - HTML generation library
 * Copyright (c) 2014, Sandeep Gupta
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

import java.util.LinkedHashSet;
import java.util.Set;

import com.sangupta.htmlgen.tags.body.Div;
import com.sangupta.htmlgen.tags.body.H1;
import com.sangupta.htmlgen.tags.body.H2;
import com.sangupta.htmlgen.tags.body.H3;
import com.sangupta.htmlgen.tags.body.H4;
import com.sangupta.htmlgen.tags.body.H5;
import com.sangupta.htmlgen.tags.body.H6;
import com.sangupta.htmlgen.tags.body.IFrame;
import com.sangupta.htmlgen.tags.body.Image;
import com.sangupta.htmlgen.tags.body.Span;

/**
 * 
 * @author sangupta
 *
 */
public class HtmlBodyElement<T> extends HtmlElement<T> {
	
	/**
	 * The list of CSS classes associated with this element
	 * 
	 */
	protected final Set<String> cssClasses = new LinkedHashSet<String>();
	
	/**
	 * The list of HTML style attributes associated with this element
	 * 
	 */
	protected final Set<HtmlStyle> styles = new LinkedHashSet<HtmlStyle>(); 
	
	/**
	 * Whether this element supports children or not
	 * 
	 */
	protected boolean supportsChildren = true;
	
	/**
	 * Construct a new instance for the given element name
	 * 
	 * @param name
	 * @param clazzOfT
	 */
	public HtmlBodyElement(String name, Class<T> clazzOfT) {
		super(name, clazzOfT);
	}
	
	/**
	 * Add the given child to the list of children of this element
	 * 
	 */
	@Override
	protected T addChild(HtmlElement<?> child) {
		if(!this.supportsChildren) {
			return clazzOfT.cast(this);
		}
		
		super.addChild(child);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Remove all child elements, attributes, css, styles and text content from this element.
	 * 
	 */
	public void clear() {
		super.clear();
		this.cssClasses.clear();
		this.styles.clear();
	}

	/**
	 * Clear all existing CSS classes and add the given one as the
	 * only css class to this element.
	 * 
	 * @param clazz
	 * @return
	 */
	public T cssClass(String clazz) {
		this.cssClasses.clear();
		this.cssClasses.add(clazz);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add a CSS class to this element.
	 * 
	 * @param clazz
	 * @return
	 */
	public T addClass(String clazz) {
		this.cssClasses.add(clazz);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Remove a CSS class from this element.
	 * 
	 * @param clazz
	 * @return
	 */
	public T removeClazz(String clazz) {
		this.cssClasses.remove(clazz);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add a new style param to this element
	 * 
	 * @param name
	 * @param value
	 * @return
	 */
	public T style(String name, String value) {
		this.styles.add(new HtmlStyle(name, value));
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add a new style param to this element that has an integer value.
	 * 
	 * @param name
	 * @param value
	 * @return
	 */
	public T style(String name, int value) {
		this.styles.add(new HtmlStyle(name, String.valueOf(value)));
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add an empty <code>DIV</code> to the element
	 * 
	 * @return
	 */
	public Div div() {
		Div div = new Div();
		div.parent(this);
		
		this.addChild(div);
		return div;
	}

	/**
	 * Add an <code>IFRAME</code> with the given URL to the element
	 * 
	 * @param src
	 * @return
	 */
	public IFrame iframe(String src) {
		IFrame iframe = new IFrame(src);
		iframe.parent(this);
		this.addChild(iframe);
		return iframe;
	}
	
	/**
	 * Add the given <code>IFRAME</code> to the element
	 * 
	 * @param iframe
	 * @return
	 */
	public IFrame iframe(IFrame iframe) {
		iframe.parent(this);
		this.addChild(iframe);
		return iframe;
	}
	
	/**
	 * Add a new <code>H1</code> heading to the element with 
	 * given text.
	 * 
	 * @param text
	 * @return
	 */
	public T h1(String text) {
		H1 h1 = new H1(text);
		h1.parent(this);
		
		this.addChild(h1);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add a new <code>H1</code> heading to the element with
	 * given text and CSS class
	 * 
	 * @param text
	 * @param cssClass
	 * @return
	 */
	public T h1(String text, String cssClass) {
		H1 h1 = new H1(text);
		h1.parent(this);
		h1.addClass(cssClass);
		
		this.addChild(h1);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add the given <code>H1</code> heading to the element.
	 * 
	 * @param h1
	 * @return
	 */
	public T h1(H1 h1) {
		h1.parent(this);
		
		this.addChild(h1);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add a new <code>H2</code> heading to the element with 
	 * given text.
	 * 
	 * @param text
	 * @return
	 */
	public T h2(String text) {
		H2 h2 = new H2(text);
		h2.parent(this);
		
		this.addChild(h2);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add a new <code>H2</code> heading to the element with
	 * given text and CSS class
	 * 
	 * @param text
	 * @param cssClass
	 * @return
	 */
	public T h2(String text, String cssClass) {
		H2 h2 = new H2(text);
		h2.parent(this);
		h2.addClass(cssClass);
		
		this.addChild(h2);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add the given <code>H2</code> heading to the element.
	 * 
	 * @param h2
	 * @return
	 */
	public T h2(H2 h2) {
		h2.parent(this);
		
		this.addChild(h2);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add a new <code>H3</code> heading to the element with 
	 * given text.
	 * 
	 * @param text
	 * @return
	 */
	public T h3(String text) {
		H3 h3 = new H3(text);
		h3.parent(this);
		
		this.addChild(h3);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add a new <code>H3</code> heading to the element with
	 * given text and CSS class
	 * 
	 * @param text
	 * @param cssClass
	 * @return
	 */
	public T h3(String text, String cssClass) {
		H3 h3 = new H3(text);
		h3.parent(this);
		h3.addClass(cssClass);
		
		this.addChild(h3);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add the given <code>H3</code> heading to the element.
	 * 
	 * @param h3
	 * @return
	 */
	public T h3(H3 h3) {
		h3.parent(this);
		
		this.addChild(h3);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add a new <code>H4</code> heading to the element with 
	 * given text.
	 * 
	 * @param text
	 * @return
	 */
	public T h4(String text) {
		H4 h4 = new H4(text);
		h4.parent(this);
		
		this.addChild(h4);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add a new <code>H4</code> heading to the element with
	 * given text and CSS class
	 * 
	 * @param text
	 * @param cssClass
	 * @return
	 */
	public T h4(String text, String cssClass) {
		H4 h4 = new H4(text);
		h4.parent(this);
		h4.addClass(cssClass);
		
		this.addChild(h4);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add the given <code>H4</code> heading to the element.
	 * 
	 * @param h4
	 * @return
	 */
	public T h4(H4 h4) {
		h4.parent(this);
		
		this.addChild(h4);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add a new <code>H5</code> heading to the element with 
	 * given text.
	 * 
	 * @param text
	 * @return
	 */
	public T h5(String text) {
		H5 h5 = new H5(text);
		h5.parent(this);
		
		this.addChild(h5);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add a new <code>H5</code> heading to the element with
	 * given text and CSS class
	 * 
	 * @param text
	 * @param cssClass
	 * @return
	 */
	public T h5(String text, String cssClass) {
		H5 h5 = new H5(text);
		h5.parent(this);
		h5.addClass(cssClass);
		
		this.addChild(h5);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add the given <code>H5</code> heading to the element.
	 * 
	 * @param h5
	 * @return
	 */
	public T h5(H5 h5) {
		h5.parent(this);
		
		this.addChild(h5);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add a new <code>H6</code> heading to the element with 
	 * given text.
	 * 
	 * @param text
	 * @return
	 */
	public T h6(String text) {
		H6 h6 = new H6(text);
		h6.parent(this);
		
		this.addChild(h6);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add a new <code>H6</code> heading to the element with
	 * given text and CSS class
	 * 
	 * @param text
	 * @param cssClass
	 * @return
	 */
	public T h6(String text, String cssClass) {
		H6 h6 = new H6(text);
		h6.parent(this);
		h6.addClass(cssClass);
		
		this.addChild(h6);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add the given <code>H6</code> heading to the element.
	 * 
	 * @param h5
	 * @return
	 */
	public T h6(H6 h6) {
		h6.parent(this);
		
		this.addChild(h6);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add an empty <code>SPAN</code> to the element
	 * 
	 * @return
	 */
	public Span span() {
		Span span = new Span();
		span.parent(this);
		
		this.addChild(span);
		return span;
	}
	
	/**
	 * Add a span with the given text to the element
	 * 
	 * @param text
	 * @return
	 */
	public Span span(String text) {
		Span span = new Span(text);
		span.parent(this);
		
		this.addChild(span);
		return span;
	}
	
	/**
	 * Add the image with given URL to the element
	 * 
	 * @param src
	 * @return
	 */
	public Image image(String src) {
		Image image = new Image(src);
		image.parent(this);
		
		this.addChild(image);
		return image;
	}

	/**
	 * Add the image with given URL and dimensions to the element
	 * 
	 * @param src
	 * @param width
	 * @param height
	 * @return
	 */
	public Image image(String src, int width, int height) {
		Image image = new Image(src);
		image.width(width);
		image.height(height);
		image.parent(this);
		
		this.addChild(image);
		return image;
	}

	/**
	 * Add the given image to the element
	 * 
	 * @param image
	 * @return
	 */
	public Image image(Image image) {
		image.parent(this);
		this.addChild(image);
		
		return image;
	}
	
	/**
	 * Output custom attributes, if any, for this element
	 * 
	 */
	@Override
	protected void outCustomAttributes(StringBuilder builder) {
		if(!this.cssClasses.isEmpty()) {
			builder.append(" class='");
			for(String cssClass : this.cssClasses) {
				builder.append(cssClass);
				builder.append(' ');
			}
			builder.append('\'');
		}
		
		// now for styles
		if(!this.styles.isEmpty()) {
			builder.append(" style='");
			for(HtmlStyle style : this.styles) {
				builder.append(style.name);
				builder.append(": ");
				builder.append(style.value);
			}
			builder.append('\'');
		}
	}
}
