package mjg;

import static org.junit.Assert.*;

import org.junit.Test;

class NumberProcessorTests {

    @Test
    public void testFindPositives() {
        def numbers = (-3..3) as int[]
        def positives = new number_processor().findPositives(numbers)
        assertArrayEquals([1,2,3] as int[], positives as int[])
    }

}
