package com.example.testsetup.servlets;

import com.example.testsetup.entities.Customer;
import com.example.testsetup.repositories.CustomerRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

@WebServlet(name = "LoginDbServlet", value = "/041/loginDbServlet")
public class LoginDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/loginForm.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        CustomerRepository repository = new CustomerRepository();

        try {
            Customer existUser = repository.findByName(username);
            if(existUser.getCustomerName().equalsIgnoreCase(username)) {
                request.setAttribute("error", "This User has Registered");
                if(existUser.getPassword().compareTo(password) == 0){
                    request.setAttribute("checkCorrect", "Correct Password");
                    response.sendRedirect("../");
                }
            }
            if(existUser.getPassword().compareTo(password) != 0){
                request.setAttribute("checkCorrect","Wrong password");
                getServletContext().getRequestDispatcher("/loginForm.jsp").forward(request,response);
            }
        }catch (Exception e){
            request.setAttribute("error","Not in Database");
            getServletContext().getRequestDispatcher("/loginForm.jsp").forward(request,response);

        }



    }
}
 