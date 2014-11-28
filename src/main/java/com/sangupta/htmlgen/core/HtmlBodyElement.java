/**
 *
 * html-gen - HTML generation library
 * Copyright (c) 2014, Sandeep Gupta
 * 
 * http://sangupta.com/projects/htmlgen
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.sangupta.htmlgen.core;

import java.util.LinkedHashSet;
import java.util.Set;

import com.sangupta.htmlgen.tags.body.Address;
import com.sangupta.htmlgen.tags.body.Anchor;
import com.sangupta.htmlgen.tags.body.Article;
import com.sangupta.htmlgen.tags.body.Div;
import com.sangupta.htmlgen.tags.body.Footer;
import com.sangupta.htmlgen.tags.body.Form;
import com.sangupta.htmlgen.tags.body.H1;
import com.sangupta.htmlgen.tags.body.H2;
import com.sangupta.htmlgen.tags.body.H3;
import com.sangupta.htmlgen.tags.body.H4;
import com.sangupta.htmlgen.tags.body.H5;
import com.sangupta.htmlgen.tags.body.H6;
import com.sangupta.htmlgen.tags.body.HGroup;
import com.sangupta.htmlgen.tags.body.Header;
import com.sangupta.htmlgen.tags.body.HorizontalRule;
import com.sangupta.htmlgen.tags.body.IFrame;
import com.sangupta.htmlgen.tags.body.Image;
import com.sangupta.htmlgen.tags.body.ListItem;
import com.sangupta.htmlgen.tags.body.Nav;
import com.sangupta.htmlgen.tags.body.OrderedList;
import com.sangupta.htmlgen.tags.body.Section;
import com.sangupta.htmlgen.tags.body.Span;
import com.sangupta.htmlgen.tags.body.UnorderedList;

/**
 * 
 * @author sangupta
 *
 */
public class HtmlBodyElement<T> extends HtmlElement<T> {
	
	/**
	 * The list of CSS classes associated with this element
	 * 
	 */
	protected final Set<String> cssClasses = new LinkedHashSet<String>();
	
	/**
	 * The list of HTML style attributes associated with this element
	 * 
	 */
	protected final Set<HtmlStyle> styles = new LinkedHashSet<HtmlStyle>(); 
	
	/**
	 * Construct a new instance for the given element name
	 * 
	 * @param name
	 * @param clazzOfT
	 */
	public HtmlBodyElement(String name, Class<T> clazzOfT) {
		super(name, clazzOfT);
	}
	
	/**
	 * Remove all child elements, attributes, css, styles and text content from this element.
	 * 
	 */
	public void clear() {
		super.clear();
		this.cssClasses.clear();
		this.styles.clear();
	}

	/**
	 * Clear all existing CSS classes and add the given one as the
	 * only css class to this element.
	 * 
	 * @param cssClass
	 * @return
	 */
	public T cssClass(String cssClass) {
		this.cssClasses.clear();
		this.cssClasses.add(cssClass);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add a CSS class to this element.
	 * 
	 * @param cssClass
	 * @return
	 */
	public T addCssClass(String cssClass) {
		this.cssClasses.add(cssClass);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Remove a CSS class from this element.
	 * 
	 * @param cssClass
	 * @return
	 */
	public T removeCssClass(String cssClass) {
		this.cssClasses.remove(cssClass);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add a new style param to this element
	 * 
	 * @param name
	 * @param value
	 * @return
	 */
	public T style(String name, String value) {
		return this.style(new HtmlStyle(name, value));
	}
	
	/**
	 * Add a new style param to this element that has an integer value.
	 * 
	 * @param name
	 * @param value
	 * @return
	 */
	public T style(String name, int value) {
		return this.style(new HtmlStyle(name, String.valueOf(value)));
	}
	
	public T style(HtmlStyle htmlStyle) {
		this.styles.add(htmlStyle);
		return this.clazzOfT.cast(this);
	}
	
	/**
	 * Add an empty <code>DIV</code> to the element
	 * 
	 * @return
	 */
	public Div div() {
		return this.div(new Div());
	}
	
	/**
	 * Add given DIV to this element
	 * 
	 * @param div
	 * @return
	 */
	public Div div(Div div) {
		div.parent(this);
		
		this.addChild(div);
		return div;
	}

	/**
	 * Add an <code>IFRAME</code> with the given URL to the element
	 * 
	 * @param src
	 * @return
	 */
	public IFrame iframe(String src) {
		return this.iframe(new IFrame(src));
	}
	
	/**
	 * Add the given <code>IFRAME</code> to the element
	 * 
	 * @param iframe
	 * @return
	 */
	public IFrame iframe(IFrame iframe) {
		iframe.parent(this);
		this.addChild(iframe);
		return iframe;
	}
	
	/**
	 * Add a new <code>H1</code> heading to the element with 
	 * given text.
	 * 
	 * @param text
	 * @return
	 */
	public T h1(String text) {
		return this.h1(new H1(text));
	}
	
	/**
	 * Add a new <code>H1</code> heading to the element with
	 * given text and CSS class
	 * 
	 * @param text
	 * @param cssClass
	 * @return
	 */
	public T h1(String text, String cssClass) {
		H1 h1 = new H1(text);
		h1.addCssClass(cssClass);
		
		return this.h1(h1);
	}
	
	/**
	 * Add the given <code>H1</code> heading to the element.
	 * 
	 * @param h1
	 * @return
	 */
	public T h1(H1 h1) {
		h1.parent(this);
		
		return this.addChild(h1);
	}
	
	/**
	 * Add a new <code>H2</code> heading to the element with 
	 * given text.
	 * 
	 * @param text
	 * @return
	 */
	public T h2(String text) {
		return this.h2(new H2(text));
	}
	
	/**
	 * Add a new <code>H2</code> heading to the element with
	 * given text and CSS class
	 * 
	 * @param text
	 * @param cssClass
	 * @return
	 */
	public T h2(String text, String cssClass) {
		H2 h2 = new H2(text);
		h2.addCssClass(cssClass);
		
		return this.h2(h2);
	}
	
	/**
	 * Add the given <code>H2</code> heading to the element.
	 * 
	 * @param h2
	 * @return
	 */
	public T h2(H2 h2) {
		h2.parent(this);
		
		return this.addChild(h2);
	}
	
	/**
	 * Add a new <code>H3</code> heading to the element with 
	 * given text.
	 * 
	 * @param text
	 * @return
	 */
	public T h3(String text) {
		return this.h3(new H3(text));
	}
	
	/**
	 * Add a new <code>H3</code> heading to the element with
	 * given text and CSS class
	 * 
	 * @param text
	 * @param cssClass
	 * @return
	 */
	public T h3(String text, String cssClass) {
		H3 h3 = new H3(text);
		h3.addCssClass(cssClass);
		
		return this.h3(h3);
	}
	
	/**
	 * Add the given <code>H3</code> heading to the element.
	 * 
	 * @param h3
	 * @return
	 */
	public T h3(H3 h3) {
		h3.parent(this);
		
		return this.addChild(h3);
	}
	
	/**
	 * Add a new <code>H4</code> heading to the element with 
	 * given text.
	 * 
	 * @param text
	 * @return
	 */
	public T h4(String text) {
		return this.h4(new H4(text));
	}
	
	/**
	 * Add a new <code>H4</code> heading to the element with
	 * given text and CSS class
	 * 
	 * @param text
	 * @param cssClass
	 * @return
	 */
	public T h4(String text, String cssClass) {
		H4 h4 = new H4(text);
		h4.addCssClass(cssClass);
		
		return this.h4(h4);
	}
	
	/**
	 * Add the given <code>H4</code> heading to the element.
	 * 
	 * @param h4
	 * @return
	 */
	public T h4(H4 h4) {
		h4.parent(this);
		
		return this.addChild(h4);
	}
	
	/**
	 * Add a new <code>H5</code> heading to the element with 
	 * given text.
	 * 
	 * @param text
	 * @return
	 */
	public T h5(String text) {
		return this.h5(new H5(text));
	}
	
	/**
	 * Add a new <code>H5</code> heading to the element with
	 * given text and CSS class
	 * 
	 * @param text
	 * @param cssClass
	 * @return
	 */
	public T h5(String text, String cssClass) {
		H5 h5 = new H5(text);
		h5.addCssClass(cssClass);
		
		return this.h5(h5);
	}
	
	/**
	 * Add the given <code>H5</code> heading to the element.
	 * 
	 * @param h5
	 * @return
	 */
	public T h5(H5 h5) {
		h5.parent(this);
		
		this.addChild(h5);
		return clazzOfT.cast(this);
	}
	
	/**
	 * Add a new <code>H6</code> heading to the element with 
	 * given text.
	 * 
	 * @param text
	 * @return
	 */
	public T h6(String text) {
		return this.h6(new H6(text));
	}
	
	/**
	 * Add a new <code>H6</code> heading to the element with
	 * given text and CSS class
	 * 
	 * @param text
	 * @param cssClass
	 * @return
	 */
	public T h6(String text, String cssClass) {
		H6 h6 = new H6(text);
		h6.addCssClass(cssClass);
		
		return this.h6(h6);
	}
	
	/**
	 * Add the given <code>H6</code> heading to the element.
	 * 
	 * @param h5
	 * @return
	 */
	public T h6(H6 h6) {
		h6.parent(this);
		
		return this.addChild(h6);
	}
	
	/**
	 * Add an empty <code>SPAN</code> to the element
	 * 
	 * @return
	 */
	public Span span() {
		return this.span(new Span());
	}
	
	/**
	 * Add a span with the given text to the element
	 * 
	 * @param text
	 * @return
	 */
	public Span span(String text) {
		return this.span(new Span(text));

	}
	
	/**
	 * Add given SPAN element to this element
	 * 
	 * @param span
	 * @return
	 */
	public Span span(Span span) {
		span.parent(this);
		
		this.addChild(span);
		return span;
	}
	
	/**
	 * Add the image with given URL to the element
	 * 
	 * @param src
	 * @return
	 */
	public Image image(String src) {
		return this.image(new Image(src));
	}

	/**
	 * Add the image with given URL and dimensions to the element
	 * 
	 * @param src
	 * @param width
	 * @param height
	 * @return
	 */
	public Image image(String src, int width, int height) {
		Image image = new Image(src);
		image.width(width);
		image.height(height);
		
		return this.image(image);
	}
	
	/**
	 * Add the given image to the element
	 * 
	 * @param image
	 * @return
	 */
	public Image image(Image image) {
		image.parent(this);
		this.addChild(image);
		
		return image;
	}
	
	/**
	 * Add an anchor for the given text.
	 * 
	 * @param text
	 * @return
	 */
	public T anchor(String text) {
		return this.anchor(new Anchor(text));
	}
	
	/**
	 * Add an anchor for the specified HREF and text
	 * 
	 * @param text
	 * @param href
	 * @return
	 */
	public T anchor(String text, String href) {
		return this.anchor(new Anchor(href, text));
	}
	
	/**
	 * Add given anchor to this element
	 * 
	 * @param anchor
	 * @return
	 */
	public T anchor(Anchor anchor) {
		anchor.parent(this);
		
		return this.addChild(anchor);
	}
	
	public UnorderedList ul() {
		return this.ul(new UnorderedList());
	}
	
	public UnorderedList ul(String cssClass) {
		return this.ul(new UnorderedList(cssClass));
	}
	
	public UnorderedList ul(UnorderedList ul) {
		ul.parent(this);
		
		this.addChild(ul);
		return ul;
	}
	
	public OrderedList ol() {
		return this.ol(new OrderedList());
	}
	
	public OrderedList ol(String cssClass) {
		return this.ol(new OrderedList(cssClass));
	}
	
	public OrderedList ol(OrderedList ol) {
		ol.parent(this);
		
		this.addChild(ol);
		return ol;
	}
	
	public T li(String text) {
		return this.li(new ListItem(text));
	}
	
	public T li(String text, String cssClass) {
		return this.li(new ListItem(text, cssClass));
	}
	
	public T li(ListItem li) {
		li.parent(this);
		
		return this.addChild(li);
	}
	
	public Form form() {
		return this.form(new Form());
	}
	
	public Form form(String action) {
		return this.form(new Form(action));
	}
	
	public Form form(String action, String method) {
		return this.form(new Form(action, method));
	}
	
	public Form form(Form form) {
		form.parent(this);
		
		this.addChild(form);
		return form;
	}
	
	public Header header() {
		return this.header(new Header());
	}
	
	public Header header(String text) {
		return this.header(new Header(text));
	}
	
	public Header header(String text, String cssClass) {
		return this.header(new Header(text, cssClass));
	}
	
	public Header header(Header header) {
		header.parent(this);
		
		this.addChild(header);
		return header;
	}
	
	public Address address(String text) {
		return this.address(new Address(text));
	}
	
	public Address address(Address address) {
		address.parent(this);
		
		this.addChild(address);
		return address;
	}
	
	public Article article() {
		return this.article(new Article());
	}
	
	public Article article(String cssClass) {
		return this.article(new Article(cssClass));
	}
	
	public Article article(Article article) {
		article.parent(this);
		
		this.addChild(article);
		return article;
	}
	
	public Footer footer() {
		return this.footer(new Footer());
	}
	
	public Footer footer(String text) {
		return this.footer(new Footer(text));
	}
	
	public Footer footer(String text, String cssClass) {
		return this.footer(new Footer(text, cssClass));
	}
	
	public Footer footer(Footer footer) {
		footer.parent(this);
		
		this.addChild(footer);
		return footer;
	}
	
	public Nav nav() {
		return this.nav(new Nav());
	}
	
	public Nav nav(String cssClass) {
		return this.nav(new Nav(cssClass));
	} 
	
	public Nav nav(Nav nav) {
		nav.parent(this);
		
		this.addChild(nav);
		return nav;
	}
	
	public Section section() {
		return this.section(new Section());
	}
	
	public Section section(String cssClass) {
		return this.section(new Section(cssClass));
	}
	
	public Section section(Section section) {
		section.parent(this);
		
		this.addChild(section);
		return section;
	}
	
	public HGroup hgroup() {
		return this.hgroup(new HGroup());
	}
	
	public HGroup hgroup(String cssClass) {
		return this.hgroup(new HGroup(cssClass));
	}
	
	public HGroup hgroup(HGroup section) {
		section.parent(this);
		
		this.addChild(section);
		return section;
	}
	
	public T hr() {
		return this.hr(new HorizontalRule());
	}
	
	public T hr(String cssClass) {
		return this.hr(new HorizontalRule(cssClass));
	}
	
	public T hr(HorizontalRule hr) {
		hr.parent(this);
		
		return this.addChild(hr);
	}
	
	/**
	 * Output custom attributes, if any, for this element
	 * 
	 */
	@Override
	protected void outCustomAttributes(StringBuilder builder) {
		if(!this.cssClasses.isEmpty()) {
			builder.append(" class='");
			for(String cssClass : this.cssClasses) {
				builder.append(cssClass);
				builder.append(' ');
			}
			builder.append('\'');
		}
		
		// now for styles
		if(!this.styles.isEmpty()) {
			builder.append(" style='");
			for(HtmlStyle style : this.styles) {
				builder.append(style.name);
				builder.append(": ");
				builder.append(style.value);
			}
			builder.append('\'');
		}
	}
	
}
