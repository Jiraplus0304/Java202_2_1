package int202.testweblogin.Servlet;


import int202.testweblogin.entities.Customer;
import int202.testweblogin.repositories.CustomerRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer = customerRepository.findByName(username);

        if (username == null || username.isEmpty()) {
            session.setAttribute("status", "กรุณาใส่ข้อมูล");
            if (password == null || password.isEmpty()) {
                session.setAttribute("status", "U forgot password");
                getServletContext().getRequestDispatcher("/Login.jsp").forward(request,response);
            }
            else if (customer == null) {
                session.setAttribute("status", "No info");
                getServletContext().getRequestDispatcher("/Login.jsp").forward(request,response);
            } else if (Integer.parseInt(password) != customer.getCustomerNumber()) {
                session.setAttribute("status", "password not match");
                getServletContext().getRequestDispatcher("/Login.jsp").forward(request,response);
            }
        }
        else {
            session.setAttribute("currentCustomer", customer);
            getServletContext().getRequestDispatcher("/Homepage.jsp").forward(request, response);
        }
    }
}
