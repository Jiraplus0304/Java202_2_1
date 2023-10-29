package dev.bestzige.int202sitspacemanagement.servlets;

import dev.bestzige.int202sitspacemanagement.services.AllStudent;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "allDataServlet", value = "/all-data")
public class AllDataSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        if(servletContext.getAttribute("studentContext") == null) {
            AllStudent allStudent = new AllStudent();
            servletContext.setAttribute("studentContext", allStudent);
        }

        req.getRequestDispatcher("/AllData.jsp").forward(req, resp);
    }
}
