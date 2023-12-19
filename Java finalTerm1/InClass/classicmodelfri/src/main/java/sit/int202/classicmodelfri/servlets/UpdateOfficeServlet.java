package sit.int202.classicmodelfri.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelfri.entities.Office;
import sit.int202.classicmodelfri.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "UpdateOfficeServlet", value = "/update-office")
public class UpdateOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        String update = request.getParameter("update");
        if (officeRepository.validString(update)){
            Office office = officeRepository.find(update);
            request.setAttribute("office",office);
        }
        getServletContext().getRequestDispatcher("/update-office.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        String offCode = officeRepository.validParam(request.getParameter("offCode"));
        String city = officeRepository.validParam(request.getParameter("city"));
        String country = officeRepository.validParam(request.getParameter("country"));
        String phone = officeRepository.validParam(request.getParameter("phone"));
        String state = officeRepository.validParam(request.getParameter("state"));
        String territory = officeRepository.validParam(request.getParameter("territory"));
        String address1 = officeRepository.validParam(request.getParameter("address1"));
        String address2 = officeRepository.validParam(request.getParameter("address2"));
        String postalCode = officeRepository.validParam(request.getParameter("postalCode"));

        Office newOffice = new Office();
        newOffice.setOfficeCode(offCode);
        newOffice.setCity(city);
        newOffice.setCountry(country);
        newOffice.setPhone(phone);
        newOffice.setState(state);
        newOffice.setTerritory(territory);
        newOffice.setAddressLine1(address1);
        newOffice.setAddressLine2(address2);
        newOffice.setPostalCode(postalCode);

        officeRepository.update(newOffice);
        officeRepository.close();
        response.sendRedirect(getServletContext().getContextPath()+"/office-list"); //ส่งผลลัพธ์แสดงออกมา
    }
}
 
