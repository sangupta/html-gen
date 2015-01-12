package com.sangupta.htmlgen.tags.body.edits;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class DeletedText extends HtmlBodyElement<DeletedText> {

	public DeletedText() {
		super("del", DeletedText.class);
	}
	
	public DeletedText(String text) {
		this();
		this.text(text);
	}
	
	public DeletedText(String text, String cssClass) {
		this(text);
		this.addCssClass(cssClass);
	}
	
}
