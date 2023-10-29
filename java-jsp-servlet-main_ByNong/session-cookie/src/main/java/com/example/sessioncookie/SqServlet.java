package com.example.sessioncookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SqServlet", value = "/SqServlet")
public class SqServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int k = 0;
        Cookie[] cookies = request.getCookies();

        for (Cookie c : cookies) {
            if (c.getName().equalsIgnoreCase("k")) {
                k = Integer.parseInt(c.getValue());
            }
        }

        k = k * k;

        PrintWriter out = response.getWriter();
        out.println("Result is " + k);

        System.out.println("sq called");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}