package strategy.groovy

class Multiplier {
	def adder = { x,y ->
		def total = 0
		y.times { total += x }
		total
	}
	
	def multiplier = { x,y -> x*y }
	
	int multiply(x,y,Closure strategy) {
		strategy(x,y)
	}
}