package com.example.bookwebapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "EditServlet", value = "/editUrl")
public class EditServlet extends HttpServlet {
    private static final String query =
            "update bookdata set bookname = ?, bookedition = ?, bookprice = ? where id = ?";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("id"));
        String bookName = request.getParameter("bookName");
        String bookEdition = request.getParameter("bookEdition");
        float bookPrice = Float.parseFloat(request.getParameter("bookPrice"));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book",
                    "root", "123456");
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, bookName);
            ps.setString(2, bookEdition);
            ps.setFloat(3, bookPrice);
            ps.setInt(4, id);
            int count = ps.executeUpdate();
            if (count == 1) {
                out.print("<h2>Record is Edited Successfully</h2>");
            } else {
                out.print("<h2>Record is not Edited Successfully</h2>");
            }
        } catch (SQLException se) {
            se.printStackTrace();
            out.println("<h1>" + se.getMessage() + "</h1>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h1>" + e.getMessage() + "</h1>");
        }
        out.println("<a href='home.html'>Home</a>");
        out.println("<br>");
        out.println("<a href='bookList'>Book List</a>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}