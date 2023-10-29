package com.example.sitspacemanagement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "RemoveServlet", value = "/RemoveServlet")
public class RemoveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/AddRemoveStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String id = request.getParameter("id");
        if (id != null) {
            String message;
            AllStudent allStudent = (AllStudent) session.getAttribute("allStudent");
            if (allStudent != null) {
                boolean check = allStudent.remove(id);
                if (check) {
                    message = "Remove Successful";
                } else {
                    message = "Remove Not Successful";
                }
            } else {
                message = "Remove Not Successful";
            }
            session.setAttribute("message", message);
        }
        request.getServletContext().getRequestDispatcher("/AddRemoveStudent.jsp").forward(request, response);
    }
}