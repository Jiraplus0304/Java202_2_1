package sit.int202.register;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession mySession = request.getSession(false);
        if(mySession!=null){
            mySession.invalidate();
        }
    }

    public void destroy() {
    }
}