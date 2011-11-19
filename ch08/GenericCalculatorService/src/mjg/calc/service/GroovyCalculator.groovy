package mjg.calc.service

class GroovyCalculator implements Calculator {
	double add(double x, double y) { x + y }
	double subtract(double x, double y) { x - y }
	double multiply(double x, double y) { x*y }
	double divide(double x, double y) { x/y }
}
