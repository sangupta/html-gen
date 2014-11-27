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

package com.sangupta.htmlgen.tags.body;

import com.sangupta.htmlgen.core.HtmlBodyElement;

/**
 * 
 * @author sangupta
 *
 */
public class IFrame extends HtmlBodyElement<IFrame> {

	public IFrame() {
		super("iframe", IFrame.class);
		this.supportsChildren = false;
	}
	
	public IFrame(String src) {
		this();
		this.src(src);
	}

	public IFrame src(String src) {
		this.attribute("src", src);
		return this;
	}
	
	public IFrame width(int width) {
		this.attribute("width", String.valueOf(width));
		return this;
	}
	
	public IFrame height(int height) {
		this.attribute("height", String.valueOf(height));
		return this;
	}
	
	public IFrame type(String type) {
		this.attribute("type", type);
		return this;
	}
	
}