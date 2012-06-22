package builders

import groovy.xml.MarkupBuilder;

def writer = new StringWriter()
def builder = new MarkupBuilder(writer)
def department = builder.'department' {
	deptName "Construction"
	employee(id:1) {
		empName "Fred"
	}
	employee(id:2) {
		empName "Barney"
	}
}
println writer

builder = new MarkupBuilder()
builder.numbers {
	(0..5).each {
		num it
	}
}