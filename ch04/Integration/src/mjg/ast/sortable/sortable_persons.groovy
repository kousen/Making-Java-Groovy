package mjg.ast.sortable

import groovy.transform.Sortable

@Sortable
class Person {
    String last
    String first

    String toString() { "$first $last" }
}

def people = [
        new Person(first: 'Fred', last: 'Flintstone'),
        new Person(first: 'Barney', last: 'Rubble'),
        new Person(first: 'Betty', last: 'Rubble'),
        new Person(first: 'Wilma', last: 'Flintstone'),
        new Person(first: 'Pebbles', last: 'Flintstone')
]

def sorted = people.sort()
assert sorted*.toString() == [
        'Fred Flintstone', 'Pebbles Flintstone', 'Wilma Flintstone',
        'Barney Rubble', 'Betty Rubble'
]
