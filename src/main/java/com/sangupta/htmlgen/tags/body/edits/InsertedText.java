package com.sangupta.htmlgen.tags.body.edits;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class InsertedText extends HtmlBodyElement<InsertedText> {

	public InsertedText() {
		super("ins", InsertedText.class);
	}
	
	public InsertedText(String text) {
		this();
		this.text(text);
	}
	
	public InsertedText(String text, String cssClass) {
		this(text);
		this.addCssClass(cssClass);
	}
	
}
