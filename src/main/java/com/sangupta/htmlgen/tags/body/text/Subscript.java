package com.sangupta.htmlgen.tags.body.text;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class Subscript extends HtmlBodyElement<Subscript> {

	public Subscript() {
		super("sub", Subscript.class);
	}
	
	public Subscript(String text) {
		this();
		this.text(text);
	}
	
	public Subscript(String text, String cssClass) {
		this(text);
		this.addCssClass(cssClass);
	}
	
}
