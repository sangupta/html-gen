/**
 *
 * html-gen - HTML generation library
 * Copyright (c) 2014-2015, Sandeep Gupta
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

package com.sangupta.htmlgen;

import com.sangupta.htmlgen.core.DocType;
import com.sangupta.htmlgen.tags.body.grouping.Div;
import com.sangupta.htmlgen.tags.head.Link;

/**
 * 
 * @author sangupta
 *
 */
public class MakeHtmlTest {
	
	public static void main(String[] args) {
		Html html = new Html().docType(DocType.HTML5);
		html.head().title("This is a sample").meta("charset", "utf8");
		html.head().link(new Link("http://cdn.sstatic.net/stackoverflow/img/favicon.ico?v=038622610830").rel("shortcut icon").type("text/javascript"));
		html.head().script("http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js");
		
		HtmlBody body = html.body();
		body.iframe("https://www.youtube.com/watch?v=09YtvBkHTTo");
		body.addCssClass("question-page new-topbar");
		
		Div div = body.div().addCssClass("topbar").div().addCssClass("child node").text("hello world");
		div.span("in bold").parent(Div.class).text("after span").parent(HtmlBody.class).iframe("sangupta");
		
		body.h1("h1").h2("h2").h3("h3").h4("h4").h5("h5").h6("h6");
		
		body.anchor("snagupta.com", "sandeep gupta").anchor("anohter link", "some other site").anchor("hello");
		
		body.ul().li("first").li("second").li("third").li("fourth");
		body.ol().li("first").li("second").li("third").li("fourth");

		System.out.println(html.asString());
	}

}
