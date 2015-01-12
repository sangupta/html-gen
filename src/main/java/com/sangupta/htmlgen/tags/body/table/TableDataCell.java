package com.sangupta.htmlgen.tags.body.table;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class TableDataCell extends HtmlBodyElement<TableDataCell> {

	public TableDataCell() {
		super("td", TableDataCell.class);
	}
	
	public TableDataCell(String text) {
		this();
		this.text(text);
	}
	
	public TableDataCell(String text, String cssClass) {
		this(text);
		this.addCssClass(cssClass);
	}
	
}
