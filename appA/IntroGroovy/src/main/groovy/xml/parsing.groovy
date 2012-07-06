/* ===================================================
 * Copyright 2012 Kousen IT, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */
package xml

String fileName = 'src/main/groovy/xml/books.xml'
def booksWithParser = new XmlParser().parse(fileName)
def booksWithSlurper = new XmlSlurper().parse(fileName)

assert booksWithParser.book.size() == 4
assert booksWithSlurper.book.size() == 4

assert booksWithParser.book[0].title.text() == "Groovy in Action"
assert booksWithSlurper.book[0].title == "Groovy in Action"


assert booksWithParser.book.find { 
	it.@isbn == "9781935182948" 
}.title.text() == "Making Java Groovy"


assert booksWithSlurper.book.find { 
	it.@isbn == "9781935182948" 
}.title == "Making Java Groovy"


def prices = []
booksWithParser.book.price.each {
	prices << it.text().toDouble()
}
assert prices == [39.99, 35.99, 35.99, 27.50]
assert prices.sum() == 139.47

prices = []
booksWithSlurper.book.price.each {
	prices << it.toDouble()
}
assert prices == [39.99, 35.99, 35.99, 27.50]
assert prices.sum() == 139.47
