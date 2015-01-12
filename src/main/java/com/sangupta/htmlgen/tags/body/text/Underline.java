package com.sangupta.htmlgen.tags.body.text;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class Underline extends HtmlBodyElement<Underline> {

	public Underline() {
		super("u", Underline.class);
	}
	
	public Underline(String text) {
		this();
		this.text(text);
	}
	
	public Underline(String text, String cssClass) {
		this(text);
		this.addCssClass(cssClass);
	}
	
}
