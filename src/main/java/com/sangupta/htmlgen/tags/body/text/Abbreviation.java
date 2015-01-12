package com.sangupta.htmlgen.tags.body.text;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class Abbreviation extends HtmlBodyElement<Abbreviation> {

	public Abbreviation() {
		super("abbr", Abbreviation.class);
	}
	
	public Abbreviation(String text) {
		this();
		this.text(text);
	}
	
	public Abbreviation(String text, String cssClass) {
		this(text);
		this.addCssClass(cssClass);
	}
	
}
