package com.sangupta.htmlgen.tags.body;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class Nav extends HtmlBodyElement<Nav> {
	
	public Nav() {
		super("nav", Nav.class);
	}
	
	public Nav(String cssClass) {
		this();
		this.addCssClass(cssClass);
	}

}
