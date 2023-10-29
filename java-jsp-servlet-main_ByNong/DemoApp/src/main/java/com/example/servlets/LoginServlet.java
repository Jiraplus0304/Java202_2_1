package com.example.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String em = request.getParameter("em");
        String ps = request.getParameter("ps");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        RequestDispatcher rd;

        if ("demo@gmail.com".equals(em) && ps.equals(ps)) {
            // home page redirect
//            rd = request.getRequestDispatcher("/second");
//            rd.forward(request, response);
            response.sendRedirect("/second");
        } else {
            // redirect login page
            out.println("<h4>Invalid email & password</h4>");
            rd = request.getRequestDispatcher("/index.jsp");
            rd.include(request, response);
        }
    }
}