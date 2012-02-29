package mjg

import groovy.servlet.ServletBinding;
import groovy.servlet.ServletCategory;

import javax.servlet.ServletConfig
import javax.servlet.ServletContext
import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class ServletWithBinding extends HttpServlet {
    ServletContext context
    
    void init(ServletConfig config) throws ServletException {
        super.init(config)
        context = config.servletContext
	}
    
    protected void service(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException ,IOException {
        ServletBinding binding = new ServletBinding(request, response, context)
        use (ServletCategory) {
            request.name = 'Hello, ' + (request.getParameter('name') ?: 'World')
        }
        binding.forward('hello.jsp')
	}
}
