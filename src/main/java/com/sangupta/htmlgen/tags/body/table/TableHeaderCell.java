package com.sangupta.htmlgen.tags.body.table;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class TableHeaderCell extends HtmlBodyElement<TableHeaderCell> {

	public TableHeaderCell() {
		super("th", TableHeaderCell.class);
	}
	
	public TableHeaderCell(String text) {
		this();
		this.text(text);
	}
	
	public TableHeaderCell(String text, String cssClass) {
		this(text);
		this.addCssClass(cssClass);
	}
	
}
