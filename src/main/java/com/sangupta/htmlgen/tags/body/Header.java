package com.sangupta.htmlgen.tags.body;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class Header extends HtmlBodyElement<Header> {

	public Header() {
		super("header", Header.class);
	}
	
	public Header(String text) {
		this();
		this.text(text);
	}
	
	public Header(String text, String cssClass) {
		this(text);
		this.addCssClass(cssClass);
	}
}
