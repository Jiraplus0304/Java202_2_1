package sit.int202.classicmodels.serlvets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.repositories.OfficeRepository;
import sit.int202.classicmodels.utils.StringUtils;

import java.io.IOException;

@WebServlet(name = "OfficeListServlet", value = "/S")
public class OfficeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        String cityOrCountry = request.getParameter("cityOrCountry");
        if(StringUtils.isBlank(cityOrCountry)) {
            request.setAttribute("offices", officeRepository.findAll());
        } else {
            request.setAttribute("offices", officeRepository.findByCityOrCountry(cityOrCountry));
        }
        getServletContext().getRequestDispatcher("/office-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

