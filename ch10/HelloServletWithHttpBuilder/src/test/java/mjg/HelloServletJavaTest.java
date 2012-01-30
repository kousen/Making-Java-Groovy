package mjg;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class HelloServletJavaTest {

    @Test
    public void testDoGet() {
        HelloServlet servlet = new HelloServlet();
        MockHttpServletRequest req = new MockHttpServletRequest();
        MockHttpServletResponse resp = new MockHttpServletResponse();
        try {
            servlet.doGet(req, resp);
            assertEquals("Hello, Servlet!", resp.getContentAsString().trim());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
