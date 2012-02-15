package mjg;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;

class ServletWithSessionAndRequestTest {
    ServletWithSessionAndRequest servlet = new ServletWithSessionAndRequest()

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testDoGetHttpServletRequestHttpServletResponse() {
        MockHttpServletRequest req = new MockHttpServletRequest()
        MockHttpServletResponse resp = new MockHttpServletResponse()
        MockHttpSession session = new MockHttpSession()
        req.setSession(session)
        servlet.doGet(req, resp)
        assert '/output.jsp' == resp.redirectedUrl
        assert session.getValue("sessionVar") == 'sessionVal'
    }

}
