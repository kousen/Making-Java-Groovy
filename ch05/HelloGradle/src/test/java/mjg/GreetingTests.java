package mjg;

import static org.junit.Assert.*;
import org.junit.Test;

public class GreetingTests {
    private Greeting greeting = new Greeting();
    
    @Test
    public void testGetGreeting() {
        assertEquals("Hello, World!", greeting.getMessage());
    }
    
    @Test
    public void testSetGreeting() {
        greeting.setMessage("What up?");
        assertEquals("What up?", greeting.getMessage());
    }
}