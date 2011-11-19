package mjg.immutable;

import static org.junit.Assert.assertEquals;
import mjg.ast.immutable.ImmutablePoint;

import org.junit.Test;

public class ImmutablePointJUnitTest {
    private ImmutablePoint p;

    @Test
    public void testImmutablePoint() {
        p = new ImmutablePoint(3,4);
        assertEquals(3.0, p.getX(), 0.0001);
        assertEquals(4.0, p.getY(), 0.0001);
    }
}
