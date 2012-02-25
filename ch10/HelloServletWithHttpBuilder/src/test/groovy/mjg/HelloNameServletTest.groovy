package mjg;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

class HelloNameServletTest {
    HelloNameServlet servlet = new HelloNameServlet()

    @Test
    public void testDoGet() {
        MockHttpServletRequest req = new MockHttpServletRequest()
        MockHttpServletResponse resp = new MockHttpServletResponse()
        MockHttpSession session = new MockHttpSession()
        req.session = session
		req.setParameter('name','Dolly')
        servlet.doGet(req, resp)
        assert 'hello.jsp' == resp.forwardedUrl
        assert session.getValue("count") == 1
    }

}
