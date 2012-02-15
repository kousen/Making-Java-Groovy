<html>
     <head>
        <title>Hello, Servlet</title>
     </head>
     <body>
        <% use (groovy.servlet.ServletCategory) { %>
        <h2>Hello, ${request.name}!</h2>
        <% } %>
     </body>
</html>