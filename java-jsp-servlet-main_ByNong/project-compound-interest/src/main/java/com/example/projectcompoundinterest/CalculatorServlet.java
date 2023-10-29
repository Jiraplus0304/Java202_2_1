package com.example.projectcompoundinterest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"", "/"})
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String principleAmount = request.getParameter("principleAmount");
        String interestPercentage = request.getParameter("interest");
        String years = request.getParameter("years");
        String compoundingPeriod = request.getParameter("compoundingPeriod");

        String error;

        if (principleAmount == null || interestPercentage == null || years == null
                || years.isBlank() || compoundingPeriod == null || compoundingPeriod.isBlank()
            || principleAmount.isBlank() || interestPercentage.isBlank()) {
            error = "One or more of the input boxes were blank. Yry again.";
            request.setAttribute("error", error);
        } else {
            double result = Utils.calculateCompoundInterest(Double.parseDouble(principleAmount),
                    Double.parseDouble(interestPercentage) / 100,
                    Integer.parseInt(years), Integer.parseInt(compoundingPeriod));
            request.setAttribute("result", result);
        }
        request.setAttribute("principal", principleAmount);
        request.setAttribute("interest", interestPercentage);
        request.setAttribute("years", years);
        request.setAttribute("compoundingPeriod", compoundingPeriod);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}