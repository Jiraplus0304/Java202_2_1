package com.example.multiplication.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "MultiplicationServlet",value = "/multiplication_table")
public class MultiplicationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numberStr = req.getParameter("number");
        if(numberStr == null || numberStr.length() == 0 || ! isNumber(numberStr)){
            req.setAttribute("error","Incalid Number or Parameter !!!");
        }
        req.getRequestDispatcher("/multiplication_table.jsp").forward(req,resp);
    }
    private static boolean isNumber(String nstr){
        for (int i = 0; i < nstr.length(); i++) {
            if (! Character.isDigit(nstr.charAt(i))){
                return false;
            }
        }
        return true;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
