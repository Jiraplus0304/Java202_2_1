package com.example.testsetup.servlets;

import com.example.testsetup.entities.Customer;
import com.example.testsetup.repositories.CustomerRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.*;

@WebServlet(name = "RegisterServlet", value = "/041/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registerForm.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Customer customer = new Customer();
        customer.setCustomerNumber(498);
        customer.setCustomerName(username);
        customer.setContactLastName("x");
        customer.setContactFirstName("x");
        customer.setPhone("123-456-789");
        customer.setAddressLine1("1254/1245");
        customer.setAddressLine2("bkk");
        customer.setCity("bkk");
        customer.setState("BKK");
        customer.setPostalCode("1542");
        customer.setCountry("1542");
        customer.setSalesRepEmployeeNumber(null);
        customer.setCreditLimit(0.00);
        customer.setPassword(password);

        CustomerRepository repository = new CustomerRepository();
        repository.insert(customer);


    }
}
 