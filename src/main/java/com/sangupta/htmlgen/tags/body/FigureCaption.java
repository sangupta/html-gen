package com.sangupta.htmlgen.tags.body;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class FigureCaption extends HtmlBodyElement<FigureCaption> {

	public FigureCaption() {
		super("figcaption", FigureCaption.class);
	}
	
	public FigureCaption(String text) {
		this();
		this.text(text);
	}
	
	public FigureCaption(String text, String cssClass) {
		this(text);
		this.addCssClass(cssClass);
	}
	
}
