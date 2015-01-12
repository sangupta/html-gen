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
public class Map extends HtmlBodyElement<Map> {

	public Map() {
		super("map", Map.class);
	}

	public Map(String name) {
		this();
		this.attr("name", name);
	}
	
	public Area area() {
		return this.area(new Area());
	}
	
	public Area area(String shape) {
		return this.area(new Area(shape));
	}
	
	public Area area(String shape, String href) {
		return this.area(new Area(shape, href));
	}
	
	public Area area(Area area) {
		this.addChild(area);
		return area;
	}
	
}
