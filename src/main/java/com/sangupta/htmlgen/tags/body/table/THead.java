package com.sangupta.htmlgen.tags.body.table;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class THead extends HtmlBodyElement<THead> {

	public THead() {
		super("thead", THead.class);
	}
	
	public THead(String cssClass) {
		this();
		this.addCssClass(cssClass);
	}
	
}
