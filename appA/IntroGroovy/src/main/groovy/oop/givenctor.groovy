package oop

class Employee {
	int id
	String name
	
	Employee(id,name) {
		this.id = id
		this.name = name
	}
	
	String toString() {
		"($id,$name)"
	}
}

// Use constructor directly
def fred = new Employee(1,'Fred Flintstone')

// Coerce array using 'as'
def barney = [2, 'Barney Rubble'] as Employee

// Coercion in assignment
Employee wilma = [3, 'Wilma Flintstone']

// Spread-dot operator
def args = [4,'Betty Rubble']
def betty = new Employee(*args)

assert fred.toString() == '(1,Fred Flintstone)'
assert barney.toString() == '(2,Barney Rubble)'
assert wilma.toString() == '(3,Wilma Flintstone)'
assert betty.toString() == '(4,Betty Rubble)'