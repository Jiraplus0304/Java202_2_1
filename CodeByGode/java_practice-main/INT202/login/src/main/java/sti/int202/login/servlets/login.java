package sti.int202.login.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sti.int202.login.models.UserPass;

import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String User = request.getParameter("Username");
        String Pass = request.getParameter("Password");
        HttpSession session = request.getSession();
        UserPass UserPass = (UserPass)session.getAttribute("UserPass");
        if (UserPass.getUser(User)) {
            if (UserPass.getPass(User).equals(Pass)){
                response.sendRedirect("index.jsp");
            }else {
                response.sendRedirect("login.jsp");
            }
        } else {
            response.sendRedirect("singup.jsp");
        }



//        String sessionUser = (String) session.getAttribute("User");
//        String sessionPass = (String) session.getAttribute("Pass");
//        if (session != null) {
//            if (User.equals(sessionUser) && Pass.equals(sessionPass)){
//                response.sendRedirect("index.jsp");
//            }else {
//                response.sendRedirect("login.jsp");
//            }
//        } else {
//            response.sendRedirect("singup.jsp");
//        }
    }
}