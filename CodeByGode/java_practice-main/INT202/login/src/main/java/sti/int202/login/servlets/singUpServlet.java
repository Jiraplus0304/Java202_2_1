package sti.int202.login.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sti.int202.login.models.UserPass;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "singupServlet", value = "/singUp")
public class singUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String User = request.getParameter("Username");
        String Pass = request.getParameter("Password");
        HttpSession session = request.getSession();
        UserPass UserPass = (UserPass)session.getAttribute("UserPass");
        if (UserPass != null){
            UserPass.AddUserPass(User,Pass);
        }else {
            UserPass UserNew = new UserPass();
            UserNew.AddUserPass(User,Pass);
            session.setAttribute("UserPass", UserNew);
        }
        response.sendRedirect("login.jsp");
    }
}