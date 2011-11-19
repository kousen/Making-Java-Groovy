package oop

class MyBook {
    String isbn
    String title
}

def b1 = new MyBook()
def b2 = new MyBook(isbn:'1-932394-84-2')
def b3 = new MyBook(title:'GinA')
def b4 = new MyBook(isbn:'1-59059-758-3',title:'DGG')

assert b2.isbn == '1-932394-84-2'
assert b3.title == 'GinA'
assert b4.isbn == '1-59059-758-3'
assert b4.title == 'DGG'