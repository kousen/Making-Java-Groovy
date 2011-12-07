package oop

import spock.lang.Specification;

class CircleSpec extends Specification {
	Circle c
	
	def setup() { c = new Circle(radius:1) }
	
	def "get area works"() {
		expect: c.area == Math.PI 
	}
	
	def "can change radius"() {
		when: c.radius = 2
		then: Math.abs(c.area - 4*Math.PI) < 0.00001
	}
	
	def "can't modify area"() {
		when:
		c.area = 6
		
		then:
		thrown(ReadOnlyPropertyException)
	}
	
	def "no setter for name"() {
		when: c.setName('name')
		then: thrown(MissingMethodException)
	}
	
	def "no getter for name"() {
		when: c.getName()
		then: thrown MissingMethodException
	}
}
