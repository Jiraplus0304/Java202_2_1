package sit.int202.classicmodelfri.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelfri.entities.Office;
import sit.int202.classicmodelfri.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "AddOfficeServlet", value = "/add-office")
public class AddOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/add-office.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        //รับparameterจากreqeustที่ส่งมาจาก add-office.jsp
        String officeCode = officeRepository.validParam(request.getParameter("offCode"));
        String city = officeRepository.validParam(request.getParameter("city"));
        String country = officeRepository.validParam(request.getParameter("country"));
        String phone = officeRepository.validParam(request.getParameter("phone"));
        String state = officeRepository.validParam(request.getParameter("state"));
        String territory = officeRepository.validParam(request.getParameter("territory"));
        String add1 = officeRepository.validParam(request.getParameter("address1"));
        String add2 = officeRepository.validParam(request.getParameter("address2"));
        String postCode = officeRepository.validParam(request.getParameter("postalCode"));


        Office office = new Office();
        //setค่าoffice ก่อนinsertไปยังdatabase
        office.setOfficeCode(officeCode);
        office.setCity(city);
        office.setCountry(country);
        office.setPhone(phone);
        office.setState(state);
        office.setTerritory(territory);
        office.setAddressLine1(add1);
        office.setAddressLine2(add2);
        office.setPostalCode(postCode);

        officeRepository.insert(office);//insertข้อมูลไปยังdatabase
        officeRepository.close();
        response.sendRedirect(getServletContext().getContextPath() + "/office-list");//redirectกลับไปที่หน้าoffice-list

    }
}
 
