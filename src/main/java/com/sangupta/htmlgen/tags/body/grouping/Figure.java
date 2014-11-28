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

package com.sangupta.htmlgen.tags.body.grouping;

import com.sangupta.htmlgen.core.HtmlBodyElement;
import com.sangupta.htmlgen.tags.body.embed.Image;

/**
 * 
 * @author sangupta
 *
 */
public class Figure extends HtmlBodyElement<Figure> {

	public Figure() {
		super("figure", Figure.class);
	}
	
	public Figure(String imageSrc) {
		this();
		this.addChild(new Image(imageSrc));
	}
	
	public Figure(Image image) {
		this();
		this.addChild(image);
	}
	
	public Figure(String imageSrc, String caption) {
		this(imageSrc);
		this.addChild(new FigureCaption(caption));
	}
	
	public Figure(Image image, FigureCaption caption) {
		this();
		this.addChild(image);
		this.addChild(caption);
	}
	
	public FigureCaption figureCaption() {
		return this.figureCaption(new FigureCaption());
	}
	
	public FigureCaption figureCaption(String text) {
		return this.figureCaption(new FigureCaption(text));
	}
	
	public FigureCaption figureCaption(String text, String cssClass) {
		return this.figureCaption(new FigureCaption(text, cssClass));
	}
	
	public FigureCaption figureCaption(FigureCaption figureCaption) {
		this.addChild(figureCaption);
		return figureCaption;
	}
	
}
