package com.sangupta.htmlgen.tags.body.table;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class TableRow extends HtmlBodyElement<TableRow> {

	public TableRow() {
		super("tr", TableRow.class);
	}
	
	public TableRow(String cssClass) {
		this();
		this.addCssClass(cssClass);
	}
	
	public TableRow newRow() {
		THead thead = this.parent(THead.class);
		if(thead != null) {
			return thead.tr();
		}
		
		TBody tbody = this.parent(TBody.class);
		if(tbody != null) {
			return tbody.tr();
		}
		
		Table table = this.parent(Table.class);
		if(table != null) {
			return table.tbody().tr();
		}
		
		throw new IllegalStateException("Table row added where no table can be found in ancestors");
	}
	
	public Table parentTable() {
		return this.parent(Table.class);
	}
	
	public TableRow td() {
		return this.td(new TableDataCell());
	}
	
	public TableRow td(String text) {
		return this.td(new TableDataCell(text));
	}
	
	public TableRow td(String text, String cssClass) {
		return this.td(new TableDataCell(text, cssClass));
	}
	
	public TableRow td(TableDataCell cell) {
		return this.addChild(cell);
	}
	
	public TableRow th() {
		return this.th(new TableHeaderCell());
	}
	
	public TableRow th(String text) {
		return this.th(new TableHeaderCell(text));
	}
	
	public TableRow th(String text, String cssClass) {
		return this.th(new TableHeaderCell(text, cssClass));
	}
	
	public TableRow th(TableHeaderCell cell) {
		return this.addChild(cell);
	}
	
}
