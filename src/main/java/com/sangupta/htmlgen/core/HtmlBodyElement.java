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

import com.sangupta.htmlgen.tags.body.edits.DeletedText;
import com.sangupta.htmlgen.tags.body.edits.InsertedText;
import com.sangupta.htmlgen.tags.body.embed.Details;
import com.sangupta.htmlgen.tags.body.embed.IFrame;
import com.sangupta.htmlgen.tags.body.embed.Image;
import com.sangupta.htmlgen.tags.body.forms.Form;
import com.sangupta.htmlgen.tags.body.grouping.BlockQuote;
import com.sangupta.htmlgen.tags.body.grouping.Div;
import com.sangupta.htmlgen.tags.body.grouping.Figure;
import com.sangupta.htmlgen.tags.body.grouping.FigureCaption;
import com.sangupta.htmlgen.tags.body.grouping.HGroup;
import com.sangupta.htmlgen.tags.body.grouping.HorizontalRule;
import com.sangupta.htmlgen.tags.body.grouping.ListItem;
import com.sangupta.htmlgen.tags.body.grouping.OrderedList;
import com.sangupta.htmlgen.tags.body.grouping.UnorderedList;
import com.sangupta.htmlgen.tags.body.sections.Address;
import com.sangupta.htmlgen.tags.body.sections.Article;
import com.sangupta.htmlgen.tags.body.sections.Footer;
import com.sangupta.htmlgen.tags.body.sections.H1;
import com.sangupta.htmlgen.tags.body.sections.H2;
import com.sangupta.htmlgen.tags.body.sections.H3;
import com.sangupta.htmlgen.tags.body.sections.H4;
import com.sangupta.htmlgen.tags.body.sections.H5;
import com.sangupta.htmlgen.tags.body.sections.H6;
import com.sangupta.htmlgen.tags.body.sections.Header;
import com.sangupta.htmlgen.tags.body.sections.Main;
import com.sangupta.htmlgen.tags.body.sections.Nav;
import com.sangupta.htmlgen.tags.body.sections.Section;
import com.sangupta.htmlgen.tags.body.table.TBody;
import com.sangupta.htmlgen.tags.body.table.THead;
import com.sangupta.htmlgen.tags.body.table.Table;
import com.sangupta.htmlgen.tags.body.table.TableDataCell;
import com.sangupta.htmlgen.tags.body.table.TableHeaderCell;
import com.sangupta.htmlgen.tags.body.table.TableRow;
import com.sangupta.htmlgen.tags.body.text.Abbreviation;
import com.sangupta.htmlgen.tags.body.text.Anchor;
import com.sangupta.htmlgen.tags.body.text.Bold;
import com.sangupta.htmlgen.tags.body.text.Cite;
import com.sangupta.htmlgen.tags.body.text.Code;
import com.sangupta.htmlgen.tags.body.text.Emphasis;
import com.sangupta.htmlgen.tags.body.text.InlineQuote;
import com.sangupta.htmlgen.tags.body.text.Italic;
import com.sangupta.htmlgen.tags.body.text.Small;
import com.sangupta.htmlgen.tags.body.text.Span;
import com.sangupta.htmlgen.tags.body.text.Strong;
import com.sangupta.htmlgen.tags.body.text.Subscript;
import com.sangupta.htmlgen.tags.body.text.Superscript;
import com.sangupta.htmlgen.tags.body.text.Underline;

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
		return this.addChild(h5);
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
		return this.addChild(anchor);
	}
	
	public UnorderedList ul() {
		return this.ul(new UnorderedList());
	}
	
	public UnorderedList ul(String cssClass) {
		return this.ul(new UnorderedList(cssClass));
	}
	
	public UnorderedList ul(UnorderedList ul) {
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
		this.addChild(header);
		return header;
	}
	
	public Address address(String text) {
		return this.address(new Address(text));
	}
	
	public Address address(Address address) {
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
		this.addChild(section);
		return section;
	}
	
	public HGroup hgroup() {
		return this.hgroup(new HGroup());
	}
	
	public HGroup hgroup(String cssClass) {
		return this.hgroup(new HGroup(cssClass));
	}
	
	public HGroup hgroup(HGroup hgroup) {
		this.addChild(hgroup);
		return hgroup;
	}
	
	public T hr() {
		return this.hr(new HorizontalRule());
	}
	
	public T hr(String cssClass) {
		return this.hr(new HorizontalRule(cssClass));
	}
	
	public T hr(HorizontalRule hr) {
		return this.addChild(hr);
	}
	
	public Figure figure() {
		return this.figure(new Figure());
	}
	
	public Figure figure(String imageSrc) {
		return this.figure(new Figure(imageSrc));
	}
	
	public Figure figure(String imageSrc, String cssClass) {
		return this.figure(new Figure(imageSrc, cssClass));
	}
	
	public Figure figure(Image image) {
		return this.figure(new Figure(image));
	}
	
	public Figure figure(Image image, FigureCaption caption) {
		return this.figure(new Figure(image, caption));
	}
	
	public Figure figure(Figure figure) {
		this.addChild(figure);
		return figure;
	}
	
	public FigureCaption figureCaption() {
		return this.figureCaption(new FigureCaption());
	}
	
	public FigureCaption figureCaption(String text) {
		return this.figureCaption(new FigureCaption(text));
	}
	
	public FigureCaption figureCaption(String text, String cssClass) {
		return this.figureCaption(new FigureCaption(text, cssClass));
	}
	
	public FigureCaption figureCaption(FigureCaption figureCaption) {
		this.addChild(figureCaption);
		return figureCaption;
	}
	
	public Main main() {
		return this.main(new Main());
	}
	
	public Main main(String cssClass) {
		return this.main(new Main(cssClass));
	}
	
	public Main main(Main main) {
		this.addChild(main);
		return main;
	}
	
	public BlockQuote blockQuote() {
		return this.blockQuote(new BlockQuote());
	}
	
	public BlockQuote blockQuote(String cssClass) {
		return this.blockQuote(new BlockQuote(cssClass));
	}
	
	public BlockQuote blockQuote(String cssClass, String cite) {
		return this.blockQuote(new BlockQuote(cssClass, cite));
	}
	
	public BlockQuote blockQuote(BlockQuote blockQuote) {
		this.addChild(blockQuote);
		return blockQuote;
	}
	
	public InlineQuote inlineQuote() {
		return this.inlineQuote(new InlineQuote());
	}
	
	public InlineQuote inlineQuote(String cssClass) {
		return this.inlineQuote(new InlineQuote(cssClass));
	}
	
	public InlineQuote inlineQuote(String cssClass, String cite) {
		return this.inlineQuote(new InlineQuote(cssClass, cite));
	}
	
	public InlineQuote inlineQuote(InlineQuote inlineQuote) {
		this.addChild(inlineQuote);
		return inlineQuote;
	}
	
	public Cite cite() {
		return this.cite(new Cite());
	}
	
	public Cite cite(String cssClass) {
		return this.cite(new Cite(cssClass));
	}
	
	public Cite cite(Cite cite) {
		this.addChild(cite);
		return cite;
	}
	
	public Details details() {
		return this.details(new Details());
	}
	
	public Details details(String cssClass) {
		return this.details(new Details(cssClass));
	}
	
	public Details details(Details details) {
		this.addChild(details);
		return details;
	}
	
	public Table table() {
		return this.table(new Table());
	}
	
	public Table table(String cssClass) {
		return this.table(new Table(cssClass));
	}
	
	public Table table(Table table) {
		this.addChild(table);
		return table;
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
	
	public T td() {
		return this.td(new TableDataCell());
	}
	
	public T td(String text) {
		return this.td(new TableDataCell(text));
	}
	
	public T td(String text, String cssClass) {
		return this.td(new TableDataCell(text, cssClass));
	}
	
	public T td(TableDataCell cell) {
		return this.addChild(cell);
	}
	
	public T th() {
		return this.th(new TableHeaderCell());
	}
	
	public T th(String text) {
		return this.th(new TableHeaderCell(text));
	}
	
	public T th(String text, String cssClass) {
		return this.th(new TableHeaderCell(text, cssClass));
	}
	
	public T th(TableHeaderCell cell) {
		return this.addChild(cell);
	}
	
	public T em() {
		return this.em(new Emphasis());
	}
	
	public T em(String text) {
		return this.em(new Emphasis(text));
	}
	
	public T em(String text, String cssClass) {
		return this.em(new Emphasis(text, cssClass));
	}
	
	public T em(Emphasis em) {
		return this.addChild(em);
	}
	
	public T abbr() {
		return this.abbr(new Abbreviation());
	}
	
	public T abbr(String text) {
		return this.abbr(new Abbreviation(text));
	}
	
	public T abbr(String text, String cssClass) {
		return this.abbr(new Abbreviation(text, cssClass));
	}
	
	public T abbr(Abbreviation abbr) {
		return this.addChild(abbr);
	}
	
	public T bold() {
		return this.bold(new Bold());
	}
	
	public T bold(String text) {
		return this.bold(new Bold(text));
	}
	
	public T bold(String text, String cssClass) {
		return this.bold(new Bold(text, cssClass));
	}
	
	public T bold(Bold bold) {
		return this.addChild(bold);
	}
	
	public T code() {
		return this.code(new Code());
	}
	
	public T code(String text) {
		return this.code(new Code(text));
	}
	
	public T code(String text, String cssClass) {
		return this.code(new Code(text, cssClass));
	}
	
	public T code(Code code) {
		return this.addChild(code);
	}
	
	public T italic() {
		return this.italic(new Italic());
	}
	
	public T italic(String text) {
		return this.italic(new Italic(text));
	}
	
	public T italic(String text, String cssClass) {
		return this.italic(new Italic(text, cssClass));
	}
	
	public T italic(Italic italic) {
		return this.addChild(italic);
	}
	
	public T underline() {
		return this.underline(new Underline());
	}
	
	public T underline(String text) {
		return this.underline(new Underline(text));
	}
	
	public T underline(String text, String cssClass) {
		return this.underline(new Underline(text, cssClass));
	}
	
	public T underline(Underline underline) {
		return this.addChild(underline);
	}
	
	public T small() {
		return this.small(new Small());
	}
	
	public T small(String text) {
		return this.small(new Small(text));
	}
	
	public T small(String text, String cssClass) {
		return this.small(new Small(text, cssClass));
	}
	
	public T small(Small small) {
		return this.addChild(small);
	}
	
	public T strong() {
		return this.strong(new Strong());
	}
	
	public T strong(String text) {
		return this.strong(new Strong(text));
	}
	
	public T strong(String text, String cssClass) {
		return this.strong(new Strong(text, cssClass));
	}
	
	public T strong(Strong strong) {
		return this.addChild(strong);
	}
	
	public T sub() {
		return this.sub(new Subscript());
	}
	
	public T sub(String text) {
		return this.sub(new Subscript(text));
	}
	
	public T sub(String text, String cssClass) {
		return this.sub(new Subscript(text, cssClass));
	}
	
	public T sub(Subscript sub) {
		return this.addChild(sub);
	}
	
	public T sup() {
		return this.sup(new Superscript());
	}
	
	public T sup(String text) {
		return this.sup(new Superscript(text));
	}
	
	public T sup(String text, String cssClass) {
		return this.sup(new Superscript(text, cssClass));
	}
	
	public T sup(Superscript sup) {
		return this.addChild(sup);
	}
	
	public T ins() {
		return this.ins(new InsertedText());
	}
	
	public T ins(String text) {
		return this.ins(new InsertedText(text));
	}
	
	public T ins(String text, String cssClass) {
		return this.ins(new InsertedText(text, cssClass));
	}
	
	public T ins(InsertedText ins) {
		return this.addChild(ins);
	}
	
	public T del() {
		return this.del(new DeletedText());
	}
	
	public T del(String text) {
		return this.del(new DeletedText(text));
	}
	
	public T del(String text, String cssClass) {
		return this.del(new DeletedText(text, cssClass));
	}
	
	public T del(DeletedText del) {
		return this.addChild(del);
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
