package sit.int202.test_login.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "singUpServlet", value = "/singUp")
public class singUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("Name");
        String email = request.getParameter("Email");
        String user = request.getParameter("Username");
        String pass = request.getParameter("Password");
        HttpSession session = request.getSession();
        if(name.length() == 0 || email.length() == 0 || user.length() == 0 || pass.length() == 0){
            request.setAttribute("message","ใส่ข้อมูลให้ครบ");
            request.getRequestDispatcher("singup.jsp").forward(request,response);
        }else {
                session.setAttribute("name" , name);
                session.setAttribute("email" , email);
                session.setAttribute("user" , user);
                session.setAttribute("pass" , pass);
                request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}