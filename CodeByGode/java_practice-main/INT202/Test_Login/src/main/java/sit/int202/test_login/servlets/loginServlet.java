package sit.int202.test_login.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("Username");
        String pass = request.getParameter("Password");
        HttpSession session = request.getSession(false);
        if (user.length() == 0 || pass.length() == 0) {
            request.setAttribute("messageLog", "ใส่ข้อมูลให้ครบ");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else if (session != null) {
            String sessionUser = (String) session.getAttribute("user");
            String sessionPass = (String) session.getAttribute("pass");
            if (sessionUser != null || sessionPass != null) {
                if (sessionUser.equals(user) && sessionPass.equals(pass)) {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else {
                    request.setAttribute("messageLog", "ใส่ข้อมูลให้ถูกด้วย");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
            request.setAttribute("messageLog", "ไปลงทะเบียนก่อน");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("messageLog", "ไปลงทะเบียนก่อน");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
