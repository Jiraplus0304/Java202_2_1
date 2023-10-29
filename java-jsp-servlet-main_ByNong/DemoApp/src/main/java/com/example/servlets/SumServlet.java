package com.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SumServlet", value = "/sum")
public class SumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int fn = Integer.parseInt(request.getParameter("fn"));
        int sn = Integer.parseInt(request.getParameter("sn"));

        int sum = fn + sn;

        request.setAttribute("s", sum);

        request.getRequestDispatcher("MultiServlet").forward(request, response);
    }
}