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

package com.sangupta.htmlgen;

import com.sangupta.htmlgen.core.DocType;
import com.sangupta.htmlgen.core.HtmlNode;

/**
 * 
 * @author sangupta
 *
 */
public class Html implements HtmlNode {
	
	/**
	 * The doctype associated with this HTML element
	 */
	protected DocType docType;
	
	/**
	 * The head for this html element
	 */
	protected final HtmlHead head;
	
	/**
	 * The body for this html element
	 */
	protected final HtmlBody body;

	/**
	 * Create a new {@link Html} instance
	 * 
	 */
	public Html() {
		this.head = new HtmlHead();
		this.head.parent(this);
		
		this.body = new HtmlBody();
		this.body.parent(this);
	}
	
	/**
	 * Create a new {@link Html} instance for given {@link DocType}.
	 * 
	 * @param docType
	 * @return
	 */
	public Html docType(DocType docType) {
		this.docType = docType;
		return this;
	}
	
	/**
	 * Set the doc type to the given string
	 * 
	 * @param type
	 * @return
	 */
	public Html docType(String type) {
		this.docType = new DocType(type);
		return this;
	}
	
	/**
	 * Return the {@link HtmlHead} for this {@link Html} instance
	 * 
	 * @return
	 */
	public HtmlHead head() {
		return this.head;
	}
	
	/**
	 * Return the {@link HtmlBody} for this {@link Html} instance
	 * 
	 * @return
	 */
	public HtmlBody body() {
		return this.body;
	}

	/**
	 * Convert this {@link Html} instance a properly organized HTML
	 * string representation.
	 * 
	 * @return
	 */
	public String asString() {
		StringBuilder builder = new StringBuilder();
		this.asString(builder);
		return builder.toString();
	}

	/**
	 * Convert and copy this {@link Html} instance to string
	 * and fill in to the given {@link StringBuilder} instance
	 * 
	 * @param builder
	 * @return
	 */
	public void asString(StringBuilder builder) {
		if(this.docType != null) {
			builder.append(this.docType.toString());
		}
		
		// start tag
		builder.append("\n<html>");
		
		// start with head
		this.head.build(builder, 1);
		
		// then the body
		this.body.build(builder, 1);
		
		builder.append("\n</html>");
	}

	/**
	 * There can be no parent to an HTML node
	 * 
	 */
	public final HtmlNode parent() {
		return null;
	}
}
