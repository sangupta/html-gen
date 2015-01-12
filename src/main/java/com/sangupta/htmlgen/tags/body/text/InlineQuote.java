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

package com.sangupta.htmlgen.tags.body.text;

import com.sangupta.htmlgen.core.HtmlBodyElement;

/**
 * 
 * @author sangupta
 *
 */
public class InlineQuote extends HtmlBodyElement<InlineQuote> {

	public InlineQuote() {
		super("q", InlineQuote.class);
	}
	
	public InlineQuote(String cssClass) {
		this();
		this.addCssClass(cssClass);
	}
	
	public InlineQuote(String cssClass, String cite) {
		this(cssClass);
		this.setCite(cite);
	}
	
	public InlineQuote setCite(String cite) {
		this.attr("cite", cite);
		return this;
	}
	
}