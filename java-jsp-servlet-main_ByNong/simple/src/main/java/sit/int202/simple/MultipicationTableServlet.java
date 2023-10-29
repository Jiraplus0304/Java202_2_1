package sit.int202.simple;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MultipicationTableServlet", value = "/multipicationTable")
public class MultipicationTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num = request.getParameter("number");
        if (num == null || !isDigit(num)) {
            request.setAttribute("message", "Invalid Parameter or No parameter!!!");
        }
        request.getRequestDispatcher("multipicationTable.jsp").forward(request, response);
    }

    private boolean isDigit (String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
