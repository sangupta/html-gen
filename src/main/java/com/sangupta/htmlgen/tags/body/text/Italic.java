package com.sangupta.htmlgen.tags.body.text;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class Italic extends HtmlBodyElement<Italic> {

	public Italic() {
		super("i", Italic.class);
	}
	
	public Italic(String text) {
		this();
		this.text(text);
	}
	
	public Italic(String text, String cssClass) {
		this(text);
		this.addCssClass(cssClass);
	}
	
}
