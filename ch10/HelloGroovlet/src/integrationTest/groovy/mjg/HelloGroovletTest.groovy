package mjg;

import static org.junit.Assert.*;

import org.junit.Test;

class HelloGroovletTest {
    int port = 8163
    
    @Test
    void testHelloGroovletWithNoName() {
        String response = "http://localhost:$port/HelloGroovlet/hello.groovy".toURL().text
        assert 'Hello, World!' == response.trim()
    }
    
    @Test
    void testHelloGroovletWithName() {
        String response = "http://localhost:$port/HelloGroovlet/hello.groovy?name=Dolly".toURL().text
        assert 'Hello, Dolly!' == response.trim()
    }
}
