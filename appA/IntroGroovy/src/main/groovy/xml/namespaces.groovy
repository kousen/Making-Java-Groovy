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

String fileName = 'src/main/groovy/xml/booksNS.xml'

// XmlParser first
def books = new XmlParser().parse(fileName)

// Declare the namespaces
def m = new groovy.xml.Namespace('urn:manning')
def p = new groovy.xml.Namespace('urn:pragprog')

// Access the titles with the namespace prefixes
assert books.book[p.title].text() == "Groovy Recipes"
assert books.book[m.title].text() == "Making Java Groovy"

// Now the XmlSlurper
books = new XmlSlurper().parse(fileName)

// Can get something right away
assert books.book.title == "Making Java GroovyGroovy Recipes"

// Create a map of prefixes to namespaces
def ns = [:]
ns.m = "urn:manning"
ns.p = "urn:pragprog"

// equivalent to def ns = [m:'urn:manning',p:'urn:pragprog']

// Declare the map
books.declareNamespace(ns)

// Now access uses the prefix, but the colon 
// means we need quotes around the element names
assert books.book['p:title'] == "Groovy Recipes"
assert books.book['m:title'] == "Making Java Groovy"