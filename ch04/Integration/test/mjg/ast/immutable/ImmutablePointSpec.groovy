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
package mjg.ast.immutable

import groovy.lang.ReadOnlyPropertyException
import spock.lang.Specification

class ImmutablePointSpec extends Specification {
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
