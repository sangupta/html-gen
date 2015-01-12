html-gen
========

Strongly typed HTML generation library for Java.

`html-gen` helps you create HTML code snippets using Java objects. It is useful in situations where
using templating engines may be an overkill. Support all HTML5 elements as listed by Mozilla
Developer Network at https://developer.mozilla.org/en/docs/Web/Guide/HTML/HTML5/HTML5_element_list

`html-gen` is an extremely lightweight and independent library - no external dependencies. `JDK 1.6+ compatible`.

Usage
-----

Generating a complete HTML file:

```java
// create new HTML object
Html html = new Html().docType(DocType.HTML5);

// write values to head
html.head()
	.title("Sample title page").meta("charset", "utf8")
	.meta("charset", "utf8")
	.meta("another meta tag", "some value");

// generate the body
html.body().div().addClass("bold").text("Sample Heading");

// Build HTML
System.out.println(html.asString());
```

This will generate the HTML output as

```html
```

### Generating a table

```java
Html html = new Html();
html.body().table()
			.thead()
				.tr().th("head1").th("head2").th("head3")
			.parentTable().tbody()
				.tr().td("1").td("2").td("3")
				.newRow().td("a").td("b").td("c");
				
System.out.println(html.asString());
```
generating HTML code as:
```html
<html>
  <head>
  </head>
  <body>
    <table>
      <thead>
        <tr>
          <th>
            head1
          </th>
          <th>
            head2
          </th>
          <th>
            head3
          </th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>
            1
          </td>
          <td>
            2
          </td>
          <td>
            3
          </td>
        </tr>
        <tr>
          <td>
            a
          </td>
          <td>
            b
          </td>
          <td>
            c
          </td>
        </tr>
      </tbody>
    </table>
  </body>
</html>
```

Changelog
---------

**Current Development**

* Iniital support for all HTML elements

Downloads
---------

The library can be downloaded from Maven Central using:

```xml
<dependency>
    <groupId>com.sangupta</groupId>
    <artifactId>html-gen</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

Versioning
----------

For transparency and insight into our release cycle, and for striving to maintain backward compatibility, 
`html-gen` will be maintained under the Semantic Versioning guidelines as much as possible.

Releases will be numbered with the follow format:

	<major>.<minor>.<patch>

And constructed with the following guidelines:

* Breaking backward compatibility bumps the major
* New additions without breaking backward compatibility bumps the minor
* Bug fixes and misc changes bump the patch

For more information on SemVer, please visit http://semver.org/.

License
-------
	
```
html-gen - HTML generation library
Copyright (c) 2014, Sandeep Gupta

	http://sangupta.com/projects/htmlgen

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
