package mjg;

import static org.junit.Assert.*;

import org.junit.Test;

public class GreetingTest {
    private Greeting greeting = new Greeting();
    
    @Test
    public void testGetMessage() {
        assertEquals("Hello, World!", greeting.getMessage());
    }

    @Test
    public void testSetMessage() {
        greeting.setMessage("What up?");
        assertEquals("What up?", greeting.getMessage());
    }

}
