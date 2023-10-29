package com.example.cookielogin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("em");
        String password = request.getParameter("ps");

        Cookie ck = new Cookie("em", email);
        Cookie ck2 = new Cookie("ps", password);

        response.addCookie(ck);
        response.addCookie(ck2);

        response.sendRedirect("profile");
    }
}