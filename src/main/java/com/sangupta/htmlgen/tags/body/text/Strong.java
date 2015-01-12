package com.sangupta.htmlgen.tags.body.text;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class Strong extends HtmlBodyElement<Strong> {

	public Strong() {
		super("strong", Strong.class);
	}
	
	public Strong(String text) {
		this();
		this.text(text);
	}
	
	public Strong(String text, String cssClass) {
		this(text);
		this.addCssClass(cssClass);
	}
	
}
