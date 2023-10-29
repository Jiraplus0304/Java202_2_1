package sit.int202.web_test.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SetThemeServlet", value = "/set_theme")
public class SetThemeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/set_theme.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bgColor = request.getParameter("bg_color");
        Cookie cookie = new Cookie("bg_color", bgColor);
        cookie.setMaxAge(60 * 60 * 24 * 365);
        response.addCookie(cookie);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}