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

package com.sangupta.htmlgen.tags.head;

import com.sangupta.htmlgen.core.HtmlElement;

/**
 * 
 * @author sangupta
 *
 */
public class Link extends HtmlElement<Link> {

	public Link() {
		super("link", Link.class);
	}
	
	public Link(String href) {
		this();
		this.href(href);
	}
	
	public Link rel(String rel) {
		this.attribute("rel", rel);
		return this;
	}
	
	public Link href(String href) {
		this.attribute("href", href);
		return this;
	}
	
	public Link type(String type) {
		this.attribute("type", type);
		return this;
	}
	
	public Link title(String title) {
		this.attribute("title", title);
		return this;
	}
	
}
