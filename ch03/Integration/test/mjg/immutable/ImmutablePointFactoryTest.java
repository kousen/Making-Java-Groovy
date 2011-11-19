package mjg.immutable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import mjg.ast.immutable.ImmutablePoint;
import mjg.ast.immutable.ImmutablePointFactory;

import org.junit.Test;

public class ImmutablePointFactoryTest {
	private ImmutablePoint p;

	@Test
	public void testNewImmutablePoint() {
//		p = ImmutablePointFactory.instance.newImmutablePoint(2, 3);
//	    p = new ImmutablePointFactory().newImmutablePoint(2, 3);
	    p = ImmutablePointFactory.newIP(2, 3);
		assertNotNull(p);
		assertEquals(2, p.getX(), 0.0001);
		assertEquals(3, p.getY(), 0.0001);
	}
}
