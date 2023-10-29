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
        Cookie[] cookies = req.getCookies(); //สร้าง array ของ cookies
        if (cookies != null) { // ถ้ามี cookiesอยู่แล้วโยนไปหน้า profile-cookie.jsp
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) { //เช็ค username
                    String[] parts = cookie.getValue().split(":"); // split username:password
                    User user = new User(parts[0], parts[1]); //  parts[0] = username , parts[1] = password
                    req.setAttribute("user", user); // เก็บ user ใน key // set request Scope

                    getServletContext().getRequestDispatcher("/profile-cookie.jsp").forward(req, resp);
                    return;
                }
            }
        }

        resp.sendRedirect(req.getContextPath() + "/login"); //ถ้าไม่มีส่งไปหน้า login
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username"); // input username
        String password = req.getParameter("password"); // input password

        if (username == null || password == null || username.isBlank() || password.isBlank()) {
            resp.sendRedirect(req.getContextPath() + "/login"); // ถ้าไม่มีเด้งมาที่หน้า login
            return;
        }

        User user = new User(username, password); // สร้าง user มารับ username,password
        Cookie cookie = new Cookie("user", user.getUsername() + ":" + user.getPassword()); // stringnified user // username:password
        cookie.setMaxAge(60 * 60 * 24 * 7); // 1 week
        resp.addCookie(cookie); // เพิ่มค่าเข้าไปใน cookie
        resp.sendRedirect(req.getContextPath() + "/user-cookie"); //login เข้าไปที่ user-cookie
    }
}
