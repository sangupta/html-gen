package com.sangupta.htmlgen.tags.body;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class HorizontalRule extends HtmlBodyElement<HorizontalRule> {

	public HorizontalRule() {
		super("hr", HorizontalRule.class);
		this.supportsChildren = false;
	}
	
	public HorizontalRule(String cssClass) {
		this();
		this.addCssClass(cssClass);
	}

}
