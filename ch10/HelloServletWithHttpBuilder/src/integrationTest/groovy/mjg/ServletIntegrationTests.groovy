package mjg;

import static org.junit.Assert.*;

import groovyx.net.http.ContentType;
import groovyx.net.http.HTTPBuilder
import org.junit.Test;

class ServletIntegrationTests {
    def httpPort = 8163
    
    @Test
    void testHelloServlet() {
        String response = "http://localhost:$httpPort/HelloServletWithHttpBuilder/hello".toURL().text.trim()
        assert response == 'Hello, Servlet!'
    }
    
    @Test
    void testHelloGroovyServlet() {
        String response = "http://localhost:$httpPort/HelloServletWithHttpBuilder/hellogs".toURL().text.trim()
        assert response == 'Hello from a Groovy Servlet!'
    }
    
    @Test
    void testHelloServletGetWithHttpBuilder() {
        def http = new HTTPBuilder("http://localhost:$httpPort/")
        def resp = http.get(path:'HelloServletWithHttpBuilder/hellogs', 
            contentType: ContentType.TEXT) { resp, reader ->
            reader.text.trim()
        }
        assert resp == 'Hello from a Groovy Servlet!'
    }
    
    @Test
    void testHelloServletPost() {
        def http = new HTTPBuilder("http://localhost:$httpPort/")
        def resp = http.post(path:'HelloServletWithHttpBuilder/hellogs',
            requestContentType: ContentType.TEXT,
            query:[name:'Dolly']) { resp, reader ->
            reader.text.trim()
        }
        assert resp == 'Hello, Dolly!'
    }
}
