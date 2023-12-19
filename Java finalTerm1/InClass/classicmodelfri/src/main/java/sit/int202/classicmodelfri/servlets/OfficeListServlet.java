package sit.int202.classicmodelfri.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.classicmodelfri.entities.Office;
import sit.int202.classicmodelfri.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeListServlet", value = "/office-list")
public class OfficeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        request.setAttribute("offices", officeRepository.findAll());
        String officeCode = request.getParameter("officeCode");
        String search = request.getParameter("search");
        if(officeRepository.validString(search)){
            request.setAttribute("search",search);
            request.setAttribute("offices",officeRepository.findByCityOrCountry(search));
        }
        if (officeCode != null) {
            request.setAttribute("selectedOffice", officeRepository.find(officeCode));
        }

        getServletContext().getRequestDispatcher("/office-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        String officeCode = request.getParameter("delete");
        Office office = new Office();
        office.setOfficeCode(officeCode);

        officeRepository.delete(office);
        officeRepository.close();
        doGet(request,response);
    }
}
 
