package com.example.mycarshop.filters;

import com.example.mycarshop.entities.Customer;
import com.example.mycarshop.repositories.CustomerRepository;
import com.mysql.cj.exceptions.ExceptionFactory;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.NoResultException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "LoggingFilter", servletNames = {"HomeServlet"})
public class LoggingFilter implements Filter {
    private FilterConfig config;

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //before invoke resources
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        CustomerRepository customerRepository = new CustomerRepository();
        String username = request.getParameter("username");
        Customer customer;
        try {
             customer = customerRepository.findByName(username);
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d, 16, 16);
            char[] password = request.getParameter("password").toCharArray();
            if (argon2.verify(customer.getPassword(),password)) {
                HttpSession session = httpServletRequest.getSession();
                session.setAttribute("curCustomer", customer);
                chain.doFilter(request, response);
            }else {
                System.out.println("not found");
                httpServletRequest.getRequestDispatcher("./index.jsp").forward(request, response);
            }
        }catch (NoResultException err){
            System.out.println("Not Found Username");
            httpServletRequest.getRequestDispatcher("./index.jsp").forward(request, response);
        }





    }

    public void destroy() {
    }
}