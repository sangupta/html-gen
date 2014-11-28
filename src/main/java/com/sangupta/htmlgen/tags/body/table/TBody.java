package com.sangupta.htmlgen.tags.body.table;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class TBody extends HtmlBodyElement<TBody> {

	public TBody() {
		super("tbody", TBody.class);
	}
	
	public TBody(String cssClass) {
		this();
		this.addCssClass(cssClass);
	}
	
}
