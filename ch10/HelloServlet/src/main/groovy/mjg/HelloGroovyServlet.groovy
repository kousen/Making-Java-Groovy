package mjg

import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class HelloGroovyServlet extends HttpServlet {
    void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        response.writer.println 'Hello from a Groovy Servlet!'
   	}
}
