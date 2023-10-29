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

@WebServlet(name = "removeServlet", value = "/remove")
public class RemoveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        if(servletContext.getAttribute("studentContext") == null) {
            AllStudent allStudent = new AllStudent();
            servletContext.setAttribute("studentContext", allStudent);
        }

        int id = Integer.parseInt(req.getParameter("id"));
        if(!NumberUtil.isInteger(req.getParameter("id"))) {
            req.setAttribute("message", "ID must be integer");
            req.getRequestDispatcher("/AddRemoveStudent.jsp").forward(req, resp);
            return;
        }

        AllStudent currentAllStudent = (AllStudent) servletContext.getAttribute("studentContext");
        boolean removed = currentAllStudent.remove(id);

        if(!removed) {
            req.setAttribute("message", "Student does not exist");
            req.getRequestDispatcher("/AddRemoveStudent.jsp").forward(req, resp);
            return;
        }

        req.setAttribute("message", "Remove student success");

        req.getRequestDispatcher("/AddRemoveStudent.jsp").forward(req, resp);
    }
}
