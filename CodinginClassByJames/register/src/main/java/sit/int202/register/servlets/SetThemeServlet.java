package sit.int202.register.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SetThemeServlet", value = "/set-theme")
public class SetThemeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/set-theme.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String backgroundColor = request.getParameter("bg");
        request.getSession().setAttribute("bg_color",backgroundColor);
        Cookie ck =new Cookie("bg_color_cookie",backgroundColor);
        ck.setMaxAge(8*24*60*60);//8 days
        response.addCookie(ck);
        request.getRequestDispatcher("/set-theme.jsp").forward(request,response);
    }
}
