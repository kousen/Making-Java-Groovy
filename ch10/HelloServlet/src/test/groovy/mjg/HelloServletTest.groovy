package mjg;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class HelloServletTest {

    @Test
    void testDoGet() {
        HelloServlet servlet = new HelloServlet()
        MockHttpServletRequest req = new MockHttpServletRequest()
        MockHttpServletResponse resp = new MockHttpServletResponse()
        servlet.doGet(req, resp)
        assertEquals 'Hello, Servlet!', resp.contentAsString.trim()
    }

}
