package com.sangupta.htmlgen.tags.body;

import com.sangupta.htmlgen.core.HtmlBodyElement;

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
	
}
