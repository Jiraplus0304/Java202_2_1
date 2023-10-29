package dev.bestzige.int202cookiesession.servlets;

import dev.bestzige.int202cookiesession.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "userServletCookie", value = "/user-cookie")
public class UserServletCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    String[] parts = cookie.getValue().split(":");
                    User user = new User(parts[0], parts[1]);
                    req.setAttribute("user", user);

                    getServletContext().getRequestDispatcher("/profile-cookie.jsp").forward(req, resp);
                    return;
                }
            }
        }

        resp.sendRedirect(req.getContextPath() + "/login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username == null || password == null || username.isBlank() || password.isBlank()) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        User user = new User(username, password);
        Cookie cookie = new Cookie("user", user.getUsername() + ":" + user.getPassword()); // username:password
        cookie.setMaxAge(60 * 60 * 24 * 7); // 1 week
        resp.addCookie(cookie);
        resp.sendRedirect(req.getContextPath() + "/user-cookie");
    }
}
