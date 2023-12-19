package sit.int202.classicmodeltue.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodeltue.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "officeListServlet", value = "/office-list")
public class officeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        request.setAttribute("offices", officeRepository.findAll());
        String officeCode = request.getParameter("officeCode");
        if (officeCode != null) {
            request.setAttribute("selectedOffice", officeRepository.find(officeCode));
        }
        getServletContext().getRequestDispatcher("/new-office-list.jsp").forward(request, response);
//        getServletContext().getRequestDispatcher("/office-list.jsp").forward(request, response);

    }
}