package sit.int202.simple.servlets;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        String browser = request.getHeader("User-Agent");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("Your Browser is " + browser + "<br>");
        out.println("<a href=\"/simple_war_exploded\">Home</a>");
        out.println("</body></html>");
    }

    public void destroy() {

    }
}