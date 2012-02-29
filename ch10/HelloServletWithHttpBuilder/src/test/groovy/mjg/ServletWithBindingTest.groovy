package mjg;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

class ServletWithBindingTest {
    ServletWithBinding servlet = new ServletWithBinding()

    @Test
    public void testDoGetWithNoName() {
        MockHttpServletRequest request = new MockHttpServletRequest()
        MockHttpServletResponse response = new MockHttpServletResponse()
        servlet.service(request, response)
        assert 'hello.jsp' == response.forwardedUrl
        assert request.getAttribute("name") == 'Hello, World'
    }

    @Test
    public void testDoGetWithName() {
        MockHttpServletRequest request = new MockHttpServletRequest()
        MockHttpServletResponse response = new MockHttpServletResponse()
        request.setParameter('name','Dolly')
        servlet.service(request, response)
        assert 'hello.jsp' == response.forwardedUrl
        assert request.getAttribute("name") == 'Hello, Dolly'
    }
}
