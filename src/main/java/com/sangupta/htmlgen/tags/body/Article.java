package com.sangupta.htmlgen.tags.body;

import com.sangupta.htmlgen.core.HtmlBodyElement;

public class Article extends HtmlBodyElement<Article> {

	public Article() {
		super("article", Article.class);
	}
	
	public Article(String cssClass) {
		this();
		this.addCssClass(cssClass);
	}
	
}
