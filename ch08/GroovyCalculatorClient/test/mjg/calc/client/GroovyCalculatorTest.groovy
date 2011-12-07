package mjg.calc.client
;

import jag.calc.service.*
import groovy.util.GroovyTestCase;

class GroovyCalculatorTest extends GroovyTestCase {
	Calculator calc

	protected void setUp() throws Exception {
		super.setUp();
		calc = new GroovyCalculatorService().groovyCalculatorPort
	}
	
	void testAdd() {
		assertEquals 5, calc.add(2,3), 0.0001
	}
	
	void testSubtract() {
		assertEquals 2, calc.subtract(5, 3), 0.0001
	}
	
	void testMultiply() {
		assertEquals 6, calc.multiply(2, 3), 0.0001
	}
	
	void testDivide() {
		assertEquals 0.25, calc.divide(1, 4), 0.0001
	}

}
