package sit.int202.customers.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.customers.models.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "customerServlet", value = "/customers")
public class customerServlet extends HttpServlet {
    List<customer> customers = new ArrayList<>(); // store customers in servletContext

    @Override
    public void init() {
        // Initialize customer list
        getServletContext().setAttribute("customers", customers);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        // if id not null = customer detail page
        if (id != null) {
            //find customer by id
            customer cs = customers.stream().filter(cus -> cus.getId() == Integer.parseInt(id)).findFirst().orElse(null); // หาไอดีที่เหมือนกัน // findfirst หาตัวแรกถ้าไม่มีโชว์ null
            if (cs == null) {
                response.sendError(404); // respond error 404
            } else {
                request.setAttribute("customer", cs); // เซฟ cs  ใส่ใน customer
                getServletContext().getRequestDispatcher("/customer-details.jsp").forward(request, response);
            }
        }
        getServletContext().getRequestDispatcher("/customers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post action
        String action = request.getParameter("action"); // get ตาม name บน customers.jsp

        if(action == null) {
            response.sendError(200); // 500 Server, 400 Client error , 300 erver error ,201 Created 200 Redirect,100 Information response
        }
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        customer cs = null;
        if(id!= null){
            //find customer by id
            cs = customers.stream().filter(cus -> cus.getId() == Integer.parseInt(id)).findFirst().orElse(null);
            if (cs == null) {
                response.sendError(404); // respond error 404
                return;
            }
        }

        if (action.equalsIgnoreCase("addCustomer")) {
            customers.add(new customer(name, phone)); // หาค่า customer ที่จะแก้ไขแล้ว save ค่าใหม่
        }

        if (action.equalsIgnoreCase("updateCustomer")) {
                cs.setName(name);
                cs.setPhone(phone);
        }

        if (action.equalsIgnoreCase("deleteCustomer")) {
            customers.remove(cs);
            //customers.removeIf(cus -> cus.getId() == Integer.parseInt(id)); // ถ้าเจอลบเลย ถ้าไม่เจอไม่ทำอะไร function ใน ArrayList
        }

        getServletContext().setAttribute("customers", customers); // save ค่า customers ใส่ใน key
        getServletContext().getRequestDispatcher("/customers.jsp").forward(request, response);
    }
}
