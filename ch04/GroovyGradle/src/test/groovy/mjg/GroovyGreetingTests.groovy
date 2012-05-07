package mjg

import static org.junit.Assert.*
import org.junit.Test

class GroovyGreetingTests {
    Greeting greeting = new Greeting()
    
    @Test
    void testGetMessage(){
        assert 'Hello, World!' == greeting.message
    }
    
    @Test
    void testSetMessage() {
        greeting.message = 'Yo, dude'
        assert 'Yo, dude' == greeting.message
    }
}