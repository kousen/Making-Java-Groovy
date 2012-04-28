package mjg

import static org.junit.Assert.*

import org.junit.Test

class GreetingTest {
    Greeting greeting = new Greeting()
    
    @Test
    void testGetMessage() {
        assertEquals "Hello, World!", greeting.message
    }

    @Test
    public void testSetMessage() {
        greeting.message = "What up?"
        assert "What up?" == greeting.message
    }

}
