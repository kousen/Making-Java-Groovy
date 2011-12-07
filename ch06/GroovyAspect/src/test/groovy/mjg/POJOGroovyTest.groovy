package mjg;

import static org.junit.Assert.*
import org.junit.Test
import org.junit.Before

class POJOGroovyTest {
    POJO pojo

    @Before
    void setUp() throws Exception {
        pojo = new POJO(one:'1',two:2,three:3.0)
    }
    
    @Test
    void testPrivateSetterAndGetter() {
        pojo.two = 22
        assertEquals(22, pojo.two)
    }

}
