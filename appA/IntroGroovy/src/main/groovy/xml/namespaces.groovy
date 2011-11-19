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