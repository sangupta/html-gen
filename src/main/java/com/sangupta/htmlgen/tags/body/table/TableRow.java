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
			return table.tr();
		}
		
		throw new IllegalStateException("Table row added where no table can be found in ancestors");
	}
	
	public Table parentTable() {
		return this.parent(Table.class);
	}
	
}
