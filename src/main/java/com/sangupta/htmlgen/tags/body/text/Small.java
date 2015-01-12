package com.sangupta.htmlgen.tags.body.text;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class Small extends HtmlBodyElement<Small> {

	public Small() {
		super("small", Small.class);
	}
	
	public Small(String text) {
		this();
		this.text(text);
	}
	
	public Small(String text, String cssClass) {
		this(text);
		this.addCssClass(cssClass);
	}
	
}
