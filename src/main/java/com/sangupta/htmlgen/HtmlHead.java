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

package com.sangupta.htmlgen;

import com.sangupta.htmlgen.core.HtmlElement;
import com.sangupta.htmlgen.tags.head.HtmlDocBase;
import com.sangupta.htmlgen.tags.head.Link;
import com.sangupta.htmlgen.tags.head.Meta;
import com.sangupta.htmlgen.tags.head.Script;
import com.sangupta.htmlgen.tags.head.Title;

/**
 * 
 * @author sangupta
 *
 */
public class HtmlHead extends HtmlElement<HtmlHead> {
	
	/**
	 * The parent {@link Html} element
	 */
	protected final Html parentHtml;
	
	/**
	 * The document {@link HtmlDocBase} to use
	 */
	protected HtmlDocBase docBase;

	/**
	 * Construct a new {@link HtmlHead} element bound to the given {@link Html}
	 * element
	 * 
	 * @param html
	 *            the {@link Html} parent element to bind to
	 */
	public HtmlHead(Html html) {
		super("head", HtmlHead.class);
		this.parentHtml = html;
	}
	
	/**
	 * Add or change the Title for this page.
	 * 
	 * @param title
	 *            the title to set to
	 *            
	 * @return the {@link HtmlHead} element over which this method was invoked
	 */
	public HtmlHead title(String title) {
		int index = this.children.indexOf("title");
		if(index == -1) {
			this.children.add(new Title().text(title));
			return this;
		}
		
		this.children.get(index).text(title);
		return this;
	}
	
	public HtmlHead meta(String name, String content) {
		this.addChild(new Meta(name, content).parent(this));
		return this;
	}
	
	public HtmlHead meta(Meta meta) {
		this.addChild(meta);
		return this;
	}

	public HtmlHead link(String href) {
		this.addChild(new Link(href).parent(this));
		return this;
	}
	
	public HtmlHead link(Link link) {
		this.addChild(link);
		return this;
	}
	
	public HtmlHead script(String src) {
		this.addChild(new Script(src).parent(this));
		return this;
	}
	
	public HtmlHead script(Script script) {
		this.addChild(script);
		return this;
	}
	
	public Html html() {
		return this.parentHtml;
	}
	
	public HtmlHead base(String href) {
		return this.base(new HtmlDocBase(href));
	}
	
	public HtmlHead base(String href, String target) {
		return this.base(new HtmlDocBase(href, target));
	}
	
	public HtmlHead base(HtmlDocBase base) {
		this.docBase = base;
		return this;
	}
	
}
