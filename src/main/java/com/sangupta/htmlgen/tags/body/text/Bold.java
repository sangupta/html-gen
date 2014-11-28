package com.sangupta.htmlgen.tags.body.text;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class Bold extends HtmlBodyElement<Bold> {

	public Bold() {
		super("b", Bold.class);
	}
	
	public Bold(String text) {
		this();
		this.text(text);
	}
	
	public Bold(String text, String cssClass) {
		this(text);
		this.addCssClass(cssClass);
	}
	
}
