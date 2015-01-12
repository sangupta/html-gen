package com.sangupta.htmlgen.tags.body.text;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class Emphasis extends HtmlBodyElement<Emphasis> {

	public Emphasis() {
		super("em", Emphasis.class);
	}
	
	public Emphasis(String text) {
		this();
		this.text(text);
	}
	
	public Emphasis(String text, String cssClass) {
		this(text);
		this.addCssClass(cssClass);
	}
	
}
