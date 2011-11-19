package strategy.java;


public class Multiplier {
	private Multiply strategy;
	
	public void setStrategy(Multiply strategy) {
		this.strategy = strategy;
	}
	
	public int multiply(int x, int y) {
		return strategy.multiply(x, y);
	}
}
