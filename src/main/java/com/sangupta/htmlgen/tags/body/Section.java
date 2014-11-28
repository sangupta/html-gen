package com.sangupta.htmlgen.tags.body;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class Section extends HtmlBodyElement<Section> {

	public Section() {
		super("section", Section.class);
	}
	
	public Section(String cssClass) {
		this();
		this.addCssClass(cssClass);
	}
	
}
