package strategy.java;

import strategy.java.AddStrategy;
import strategy.java.Multiplier;
import strategy.java.TimesStrategy;
import junit.framework.TestCase;

public class MultiplierTest extends TestCase {

	private Multiplier m;
	
	@Override
	protected void setUp() throws Exception {
		m = new Multiplier();
	}
	
	public void testAddMultiplier() {
		m.setStrategy(new AddStrategy());
		assertEquals(6, m.multiply(2, 3));
	}
	
	public void testTimesMultiplier() {
		m.setStrategy(new TimesStrategy());
		assertEquals(6, m.multiply(2, 3));
	}

}
