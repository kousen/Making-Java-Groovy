package mjg.immutable

import groovy.lang.ReadOnlyPropertyException
import mjg.ast.immutable.ImmutablePoint
import spock.lang.Specification

class ImmutablePointTest extends Specification {
	ImmutablePoint p = new ImmutablePoint(x:3,y:4)
	
	def "can use map ctor for immutables"() {
		expect: [3,4] == [p.x, p.y]
	}
	
	def "can't change x"() {
		when: p.x = 5
		then: thrown(ReadOnlyPropertyException)
	}

	def "can't change y"() {
		when: p.y = 5
		then: thrown(ReadOnlyPropertyException)
	}
}
