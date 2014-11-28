package com.sangupta.htmlgen.tags.body.table;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class Table extends HtmlBodyElement<Table> {

	public Table() {
		super("table", Table.class);
	}
	
	public Table(String cssClass) {
		this();
		this.addCssClass(cssClass);
	}
	
}
