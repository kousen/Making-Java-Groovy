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