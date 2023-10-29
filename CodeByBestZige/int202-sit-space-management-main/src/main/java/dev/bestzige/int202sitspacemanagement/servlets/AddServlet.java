package dev.bestzige.int202sitspacemanagement.servlets;

import dev.bestzige.int202sitspacemanagement.services.AllStudent;
import dev.bestzige.int202sitspacemanagement.utils.NumberUtil;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "addServlet", value = "/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        if(servletContext.getAttribute("studentContext") == null) {
            AllStudent allStudent = new AllStudent();
            servletContext.setAttribute("studentContext", allStudent);
        }

        if(!NumberUtil.isInteger(req.getParameter("id"))) {
            req.setAttribute("message", "ID must be integer");
            req.getRequestDispatcher("/AddRemoveStudent.jsp").forward(req, resp);
            return;
        }

        int id = Integer.parseInt(req.getParameter("id"));

        String name = req.getParameter("name");
        if(name == null || name.trim().equals("")) {
            req.setAttribute("message", "Name must not be empty");
            req.getRequestDispatcher("/AddRemoveStudent.jsp").forward(req, resp);
            return;
        }

        if(!NumberUtil.isDouble(req.getParameter("score"))) {
            req.setAttribute("message", "Score must be double");
            req.getRequestDispatcher("/AddRemoveStudent.jsp").forward(req, resp);
            return;
        }
        double score = Double.parseDouble(req.getParameter("score"));

        AllStudent currentAllStudent = (AllStudent) servletContext.getAttribute("studentContext");
        boolean added = currentAllStudent.add(id, name, score);

        if(!added) {
            req.setAttribute("message", "Student already exists");
            req.getRequestDispatcher("/AddRemoveStudent.jsp").forward(req, resp);
            return;
        }

        req.setAttribute("message", "Add student success");

        req.getRequestDispatcher("/AddRemoveStudent.jsp").forward(req, resp);
    }
}
