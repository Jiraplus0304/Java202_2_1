package sit.int202.simple.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "TestCookieServlet", value = "/test_cookie")
public class TestCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/test_cookie.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bgColor = request.getParameter("bg");
        Cookie ck = new Cookie("bg_cookie", bgColor);
        ck.setMaxAge(8*24*60*60);
        response.addCookie(ck);
        request.getRequestDispatcher("/test_cookie.jsp").forward(request,response);
    }
}