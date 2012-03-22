package mjg;

import static org.junit.Assert.*;

import org.junit.Test;

class ServletIntegrationTests {
    def httpPort = 8163
    
    @Test
    void testHelloServlet() {
        String response = 
            "http://localhost:$httpPort/HelloServlet/hello".toURL().text.trim()
        assert response == 'Hello, Servlet!'
    }
    
    @Test
    void testHelloGroovyServlet() {
        String response = "http://localhost:$httpPort/HelloServlet/hellogs".toURL().text.trim()
        assert response == 'Hello from a Groovy Servlet!'
    }
}
