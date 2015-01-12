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

import com.sangupta.htmlgen.core.DocType;
import com.sangupta.htmlgen.core.HtmlNode;

/**
 * 
 * @author sangupta
 *
 */
public class Html implements HtmlNode {
	
	protected DocType docType;
	
	protected final HtmlHead head;
	
	protected final HtmlBody body;

	public Html() {
		this.head = new HtmlHead();
		this.head.parent(this);
		
		this.body = new HtmlBody();
		this.body.parent(this);
	}
	
	public Html docType(DocType docType) {
		this.docType = docType;
		return this;
	}
	
	public Html docType(String type) {
		this.docType = new DocType(type);
		return this;
	}
	
	public HtmlHead head() {
		return this.head;
	}
	
	public HtmlBody body() {
		return this.body;
	}

	public String asString() {
		StringBuilder builder = new StringBuilder();
		
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
		
		return builder.toString();
	}

	/**
	 * There can be no parent to an HTML node
	 * 
	 */
	public final HtmlNode parent() {
		return null;
	}
}