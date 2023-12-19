package addremove.kak.addremovekakkak.servlet;

import java.io.*;

import addremove.kak.addremovekakkak.entities.Customer;
import addremove.kak.addremovekakkak.repositories.CustomerRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "AddRemoveCustomerServlet", value = "/add-remove-customer")
public class AddRemoveCustomerServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       String id  = request.getParameter("id");
        CustomerRepository customerRepository = new CustomerRepository();
        Customer customer = customerRepository.findByID(id);
        customerRepository.delete(customer);
        request.getRequestDispatcher("customer-list").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String customerNumber = request.getParameter("customerNumber");
        String customerName = request.getParameter("customerName");
        String contactLastName = request.getParameter("contactLastName");
        String contactFirstName = request.getParameter("contactFirstName");
        String phone = request.getParameter("phone");
        String addressLine1 = request.getParameter("addressLine1");
        String addressLine2 = request.getParameter("addressLine2");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String postalCode = request.getParameter("postalCode");
        Double creditLimit = Double.parseDouble(request.getParameter("creditLimit"));

        Customer customer = new Customer();
        customer.setCustomerNumber(customerNumber);
        customer.setCustomerName(customerName);
        customer.setContactLastName(contactLastName);
        customer.setContactFirstName(contactFirstName);
        customer.setPhone(phone);
        customer.setAddressLine1(addressLine1);
        customer.setAddressLine2(addressLine2);
        customer.setCity(city);
        customer.setState(state);
        customer.setCountry(country);
        customer.setPostalCode(postalCode);
        customer.setCreditLimit(creditLimit);

        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.insert(customer);
        request.getRequestDispatcher("customer-list").forward(request,response);
    }

    public void destroy() {
    }
}