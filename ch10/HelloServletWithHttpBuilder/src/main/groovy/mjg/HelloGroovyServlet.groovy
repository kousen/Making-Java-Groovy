package mjg

import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class HelloGroovyServlet extends HttpServlet {
    void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.contentType = 'text/plain'
        response.writer.println 'Hello from a Groovy Servlet!'
    }
        
    void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException ,IOException {
        request.parameterNames.each { println "Parameter $it" }
		String name = request.getParameter('name') ?: 'World'
        response.contentType = 'text/plain'
        response.writer.println "Hello, $name!"
	}
}
