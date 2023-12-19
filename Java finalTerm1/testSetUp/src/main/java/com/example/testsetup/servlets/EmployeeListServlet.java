package com.example.testsetup.servlets;

import com.example.testsetup.repositories.EmployeeRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

@WebServlet(name = "EmployeeListServlet", value = "/employeeListServlet")
public class EmployeeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        request.setAttribute("employees", employeeRepository.findAll());
        getServletContext().getRequestDispatcher("/EmployeeList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
 