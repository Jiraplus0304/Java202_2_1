package sit.int202.register.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

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
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}