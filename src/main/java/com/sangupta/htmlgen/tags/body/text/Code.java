package com.sangupta.htmlgen.tags.body.text;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class Code extends HtmlBodyElement<Code> {

	public Code() {
		super("code", Code.class);
	}
	
	public Code(String text) {
		this();
		this.text(text);
	}
	
	public Code(String text, String cssClass) {
		this(text);
		this.addCssClass(cssClass);
	}
	
}
