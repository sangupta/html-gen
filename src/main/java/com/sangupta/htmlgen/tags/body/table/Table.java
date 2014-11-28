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
	
	public THead thead() {
		return this.thead(new THead());
	}
	
	public THead thead(String cssClass) {
		return this.thead(new THead(cssClass));
	}
	
	public THead thead(THead thead) {
		this.addChild(thead);
		return thead;
	}
	
	public TBody tbody() {
		return this.tbody(new TBody());
	}
	
	public TBody tbody(String cssClass) {
		return this.tbody(new TBody(cssClass));
	}
	
	public TBody tbody(TBody tbody) {
		this.addChild(tbody);
		return tbody;
	}
	
}
