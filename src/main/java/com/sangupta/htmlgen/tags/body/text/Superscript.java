package com.sangupta.htmlgen.tags.body.text;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class Superscript extends HtmlBodyElement<Superscript> {

	public Superscript() {
		super("sup", Superscript.class);
	}
	
	public Superscript(String text) {
		this();
		this.text(text);
	}
	
	public Superscript(String text, String cssClass) {
		this(text);
		this.addCssClass(cssClass);
	}
	
}
