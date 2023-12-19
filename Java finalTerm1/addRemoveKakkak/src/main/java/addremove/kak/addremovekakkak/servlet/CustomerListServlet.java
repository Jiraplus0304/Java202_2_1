package addremove.kak.addremovekakkak.servlet;

import addremove.kak.addremovekakkak.repositories.CustomerRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet(name = "CustomerList", value = "/customer-list")
public class CustomerListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerRepository customerRepository = new CustomerRepository();
        var customers = customerRepository.findAll();
        request.setAttribute("customers",customers);
        request.getRequestDispatcher("./customer-list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}