package dev.bestzige.int202cookiesession.servlets;

import dev.bestzige.int202cookiesession.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "userServletSession", value = "/user-session")
public class UserServletSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession() == null || req.getSession().getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            getServletContext().getRequestDispatcher("/profile-session.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username == null || password == null || username.isBlank() || password.isBlank()) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        User user = new User(username, password);
        req.getSession().setAttribute("user", user);
        resp.sendRedirect(req.getContextPath() + "/user-session");
    }
}
