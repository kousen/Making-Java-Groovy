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
