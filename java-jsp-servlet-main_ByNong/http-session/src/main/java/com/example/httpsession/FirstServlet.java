package com.example.httpsession;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FirstServlet", value = "/servlet1")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("nm");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<h1>Name = " + name + "</h1>");

        HttpSession session = request.getSession();
        session.setAttribute("username", name);

        out.println("<a href='servlet2'>Servlet 2</a>");
    }
}