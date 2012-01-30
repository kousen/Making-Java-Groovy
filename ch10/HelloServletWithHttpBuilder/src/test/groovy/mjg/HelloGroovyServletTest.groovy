package mjg;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class HelloGroovyServletTest {

    @Test
    void testDoGet() {
        HelloGroovyServlet servlet = new HelloGroovyServlet()
        MockHttpServletRequest req = new MockHttpServletRequest()
        MockHttpServletResponse resp = new MockHttpServletResponse()
        servlet.doGet(req, resp)
        assertEquals 'Hello from a Groovy Servlet!', resp.contentAsString.trim()
    }

}
