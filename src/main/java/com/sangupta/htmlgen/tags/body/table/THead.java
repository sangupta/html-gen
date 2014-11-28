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
	
	public TableRow tr() {
		return this.tr(new TableRow());
	}
	
	public TableRow tr(String cssClass) {
		return this.tr(new TableRow(cssClass));
	}
	
	public TableRow tr(TableRow row) {
		this.addChild(row);
		return row;
	}
	
}
