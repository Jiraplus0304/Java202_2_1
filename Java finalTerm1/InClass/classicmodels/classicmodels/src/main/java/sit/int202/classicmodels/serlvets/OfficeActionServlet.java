package sit.int202.classicmodels.serlvets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.classicmodels.entities.Office;
import sit.int202.classicmodels.repositories.OfficeRepository;
import sit.int202.classicmodels.utils.StringUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "OfficeActionServlet", value = "/office-action")
public class OfficeActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();

        String action = req.getParameter("action");

        if(StringUtils.isBlank(action)) {
            // add
            req.setAttribute("action", "add");
            req.getServletContext().getRequestDispatcher("/office-form.jsp").forward(req, resp);
        } else {
            // edit -> ?action=edit&officeCode=1
            String officeCode = req.getParameter("officeCode");
            Office office = officeRepository.find(officeCode);
            if(office == null) {
                resp.sendRedirect(req.getContextPath() + "/office-list");
                return;
            }
            req.setAttribute("office", office);
            req.setAttribute("action", "update");
            req.getServletContext().getRequestDispatcher("/office-form.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();

        String action = req.getParameter("action");
        // add, update, delete

        if(action.equalsIgnoreCase("delete")) {
            String officeCode = req.getParameter("officeCode");
            Office office = officeRepository.find(officeCode);
            if(office == null) return;
            try {
                officeRepository.delete(office);
                resp.sendRedirect(req.getContextPath() + "/office-list");
            } catch (Exception e) {
                List<Office> officeList = officeRepository.findAll();
                req.setAttribute("offices", officeList);
                req.setAttribute("error", "Unable to delete");
                getServletContext().getRequestDispatcher("/office-list.jsp").forward(req,resp);
            }
            return;
        }

        if(action.equalsIgnoreCase("add")) {
            String officeCode = req.getParameter("officeCode");
            String city = req.getParameter("city");
            String phone = req.getParameter("phone");
            String addressLine1 = req.getParameter("addressLine1");
            String addressLine2 = req.getParameter("addressLine2");
            String state = req.getParameter("state");
            String country = req.getParameter("country");
            String postalCode = req.getParameter("postalCode");
            String territory = req.getParameter("territory");
            if(StringUtils.isBlank(officeCode)
                    || StringUtils.isBlank(city)
                    || StringUtils.isBlank(phone)
                    || StringUtils.isBlank(addressLine1)
                    || StringUtils.isBlank(addressLine2)
                    || StringUtils.isBlank(state)
                    || StringUtils.isBlank(country)
                    || StringUtils.isBlank(postalCode)
                    || StringUtils.isBlank(territory))
            {
                return;
            }

            Office office = new Office();
            office.setOfficeCode(officeCode);
            office.setCity(city);
            office.setPhone(phone);
            office.setAddressLine1(addressLine1);
            office.setAddressLine2(addressLine2);
            office.setState(state);
            office.setCountry(country);
            office.setPostalCode(postalCode);
            office.setTerritory(territory);

            officeRepository.insert(office);
            resp.sendRedirect(req.getContextPath() + "/office-list");
            return;
        }

        if(action.equalsIgnoreCase("update")) {
            String officeCode = req.getParameter("officeCode");
            String city = req.getParameter("city");
            String phone = req.getParameter("phone");
            String addressLine1 = req.getParameter("addressLine1");
            String addressLine2 = req.getParameter("addressLine2");
            String state = req.getParameter("state");
            String country = req.getParameter("country");
            String postalCode = req.getParameter("postalCode");
            String territory = req.getParameter("territory");

            Office office = officeRepository.find(officeCode);
            if(office == null) {
                resp.sendRedirect(req.getContextPath() + "/office-list");
                return;
            }

            if(!StringUtils.isBlank(city)) {
                office.setCity(city);
            }
            if(!StringUtils.isBlank(phone)) {
                office.setPhone(phone);
            }
            if(!StringUtils.isBlank(addressLine1)) {
                office.setAddressLine1(addressLine1);
            }
            if(!StringUtils.isBlank(addressLine2)) {
                office.setAddressLine2(addressLine2);
            }
            if(!StringUtils.isBlank(state)) {
                office.setState(state);
            }
            if(!StringUtils.isBlank(country)) {
                office.setCountry(country);
            }
            if(!StringUtils.isBlank(postalCode)) {
                office.setPostalCode(postalCode);
            }
            if(!StringUtils.isBlank(territory)) {
                office.setTerritory(territory);
            }

            officeRepository.update(office);
            resp.sendRedirect(req.getContextPath() + "/office-list");
            return;
        }
    }
}
