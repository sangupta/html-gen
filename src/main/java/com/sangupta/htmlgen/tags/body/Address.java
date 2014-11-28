package com.sangupta.htmlgen.tags.body;

import com.sangupta.htmlgen.core.HtmlBodyElement;
import com.sangupta.htmlgen.tags.Text;

public class Address extends HtmlBodyElement<Address> {

	public Address() {
		super("address", Address.class);
	}
	
	public Address(String text) {
		this();
		this.addChild(new Text(text));
	}
}
