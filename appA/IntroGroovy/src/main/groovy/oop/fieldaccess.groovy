package oop

class Book {
    String isbn
    String title
	
    String getIsbn() { return "ISBN: $isbn"	}
}

def gina = new Book(isbn:'1932394842',title:'Groovy in Action')
assert gina.isbn == "ISBN: 1932394842"
assert gina.@isbn == "1932394842"
