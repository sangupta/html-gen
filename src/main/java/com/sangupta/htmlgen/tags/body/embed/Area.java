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

package com.sangupta.htmlgen.tags.body.embed;

import com.sangupta.htmlgen.core.HtmlBodyElement;

/**
 * 
 * @author sangupta
 *
 */
public class Area extends HtmlBodyElement<Area> {

	public Area() {
		super("area", Area.class);
	}

	public Area(String shape) {
		this();
		this.attr("shape", shape);
	}
	
	public Area(String shape, String href) {
		this(shape);
		if(href != null) {
			this.attr("href", href);
		} else {
			this.attr("nohref", null);
		}
	}
	
	public Area newArea() {
		Map map = parentMap();
		if(map == null) {
			throw new IllegalStateException("Area added to HTML without a map ancestor");
		}
		
		return map.area();
	}
	
	public Area newArea(String shape) {
		Map map = parentMap();
		if(map == null) {
			throw new IllegalStateException("Area added to HTML without a map ancestor");
		}
		
		return map.area(shape);
	}
	
	public Area newArea(String shape, String href) {
		Map map = parentMap();
		if(map == null) {
			throw new IllegalStateException("Area added to HTML without a map ancestor");
		}
		
		return map.area(shape, href);
	}
	
	public Map parentMap() {
		return this.parent(Map.class);
	}
	
}
