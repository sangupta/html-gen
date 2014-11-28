package com.sangupta.htmlgen.tags.body;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class Footer extends HtmlBodyElement<Footer> {

	public Footer() {
		super("footer", Footer.class);
	}
	
	public Footer(String text) {
		this();
		this.text(text);
	}
	
	public Footer(String text, String cssClass) {
		this(text);
		this.addCssClass(cssClass);
	}
	
}
