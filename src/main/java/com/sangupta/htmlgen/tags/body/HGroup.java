package com.sangupta.htmlgen.tags.body;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class HGroup extends HtmlBodyElement<HGroup> {

	public HGroup() {
		super("hgroup", HGroup.class);
	}
	
	public HGroup(String cssClass) {
		this();
		this.addCssClass(cssClass);
	}
	
}
