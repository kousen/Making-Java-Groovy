package mjg;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

class HelloNameServletTest {
    HelloNameServlet servlet = new HelloNameServlet()

    @Test
    public void testDoGetWithNoName() {
        MockHttpServletRequest request = new MockHttpServletRequest()
        MockHttpServletResponse response = new MockHttpServletResponse()
        MockHttpSession session = new MockHttpSession()
        request.session = session
        servlet.doGet(request, response)
        assert 'hello.jsp' == response.forwardedUrl
        assert request.getAttribute("name") == 'Hello, World'
        assert session.getValue("count") == 1
    }

    @Test
    public void testDoGetWithName() {
        MockHttpServletRequest request = new MockHttpServletRequest()
        MockHttpServletResponse response = new MockHttpServletResponse()
        MockHttpSession session = new MockHttpSession()
        request.session = session
        request.setParameter('name','Dolly')
        servlet.doGet(request, response)
        assert 'hello.jsp' == response.forwardedUrl
        assert request.getAttribute("name") == 'Hello, Dolly'
        assert session.getValue("count") == 1
    }
}
