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
package strategy.groovy

import strategy.groovy.Multiplier;

class MultiplierTest extends GroovyTestCase {
	Multiplier m
	
	void setUp() {
		m = new Multiplier()
	}
	
	void testAddStrategy() {
		def result = m.multiply(2,3,m.adder) 
		assertEquals 6, result
	}
	
	void testTimesStrategy() {
		def result = m.multiply(2,3,m.multiplier)
		assertEquals 6, result
	}
	
	void testAlternativeTimesStrategy() {
		assertEquals 6, m.multiply(2, 3) { x,y ->
			def total = 0
			x.times { total += y}
			total
		}
	}
}