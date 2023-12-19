package login.kakkak.loginkakak.servlets;

import jakarta.persistence.NoResultException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import login.kakkak.loginkakak.entities.Customer;
import login.kakkak.loginkakak.repositories.CustomerRepository;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        CustomerRepository customerRepository = new CustomerRepository();
        try {
            Customer customer = customerRepository.findByName(username);
            if (String.valueOf(customer.getCustomerNumber()).equals((password))){
                session.setAttribute("CurCustomer",customer);
                session.setAttribute("orders",customer.getListOrder());
                request.getRequestDispatcher("./index.jsp").forward(request,response);
            }else {
                session.setAttribute("status","Wrong Password");
                request.getRequestDispatcher("./login.jsp").forward(request,response);
            }
        } catch (NoResultException e) {
            session.setAttribute("status","This Username is doesn't exits");
            request.getRequestDispatcher("./login.jsp").forward(request,response);
        }
    }
}