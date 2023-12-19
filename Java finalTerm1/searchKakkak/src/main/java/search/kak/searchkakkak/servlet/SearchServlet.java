package search.kak.searchkakkak.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import search.kak.searchkakkak.repositories.CustomerRepository;

import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/search-customer")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search-input");
        CustomerRepository customerRepository = new CustomerRepository();
        var customers = customerRepository.searchByName(search);
        request.setAttribute("customers",customers);
        request.getRequestDispatcher("./customer-list.jsp").forward(request,response);
    }
}