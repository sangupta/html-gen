package com.sangupta.htmlgen.tags.body.text;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class Break extends HtmlBodyElement<Break> {

	public Break() {
		super("br", Break.class);
		this.outputEndOfTag = false;
	}
	
	public Break(String cssClass) {
		this();
		this.addCssClass(cssClass);
	}
	
}
