package com.sangupta.htmlgen.tags;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class Pre extends HtmlBodyElement<Pre> {
	
	protected String textContent;

	public Pre() {
		super("pre", Pre.class);
	}
	
	public Pre(String text) {
		this();
		this.textContent = text;
	}
	
	public Pre(String text, String cssClass) {
		this(text);
		this.addCssClass(cssClass);
	}
	
	public String text() {
		return this.textContent;
	}
	
}
