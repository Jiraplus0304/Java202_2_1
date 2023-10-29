package com.example.cookielogin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Profile", value = "/profile")
public class Profile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] ck = request.getCookies();

        if (ck == null) {
            response.sendRedirect("index.jsp");
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<h1>email= " + ck[0].getValue() + "</h1>");
            out.println("<h1>password= " + ck[1].getValue() + "</h1>");
            out.println("<a href='logout'>Logout</a>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}