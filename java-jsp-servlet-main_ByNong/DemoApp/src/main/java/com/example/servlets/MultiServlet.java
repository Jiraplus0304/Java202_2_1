package com.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MultiServlet", value = "/MultiServlet")
public class MultiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int fn = Integer.parseInt(request.getParameter("fn"));
        int sn = Integer.parseInt(request.getParameter("sn"));

        int sum = (int) request.getAttribute("s");

        int mul = fn * sn;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<h1>sum = " + sum + ", multiplication = " + mul);
    }
}