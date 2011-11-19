package strategy.java;


public class AddStrategy implements Multiply {

	public int multiply(int x, int y) {
		int total = 0;
		for (int i = 0; i < y; i++) {
			total += x;
		}
		return total;
	}

}
