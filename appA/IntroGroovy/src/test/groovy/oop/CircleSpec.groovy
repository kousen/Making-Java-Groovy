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
