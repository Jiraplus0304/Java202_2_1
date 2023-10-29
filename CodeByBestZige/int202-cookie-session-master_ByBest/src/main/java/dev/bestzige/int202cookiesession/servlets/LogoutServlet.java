package dev.bestzige.int202cookiesession.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "logoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // remove session
        if(req.getSession() != null && req.getSession().getAttribute("user") != null) { //ถ้ามี session จะให้ลบตัวเอง
            req.getSession().invalidate(); // invalidate = remove ทุกตัว
            // req.getSession().removeAttribute("user"); // ลบตัวที่เรา login logout ตัวนั้น make sense กว่า
        }

        // remove cookie
        if(req.getCookies() != null) { //ถ้ามี cookies จะให้ลบตัวเอง
            for(var cookie : req.getCookies()) { // loop เพราะอาจจะมี cookies หลายตัว session ก็เหมือนกัน
                if(cookie.getName().equals("user")) { // ตรวจว่าเจอถ้า name = username
                    cookie.setMaxAge(0); // set ให้ cookies เป็น 0
                    resp.addCookie(cookie); // add cookies ที่เป็น 0 ไป
                    break;
                }
            }
        }

        resp.sendRedirect(req.getContextPath() + "/login"); // ถ้าไม่มี session or cookie จะให้ โยงไปหน้า login
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
