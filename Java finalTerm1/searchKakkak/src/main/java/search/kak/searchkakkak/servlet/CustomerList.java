package search.kak.searchkakkak.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import search.kak.searchkakkak.repositories.CustomerRepository;

import java.io.IOException;

@WebServlet(name = "CustomerList", value = "/customer-list")
public class CustomerList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerRepository customerRepository = new CustomerRepository();
        var customers = customerRepository.findAll();
        request.setAttribute("customers",customers);
        request.getRequestDispatcher("./customer-list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}