package com.example.bookwebapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "BookListServlet", value = "/bookList")
public class BookListServlet extends HttpServlet {
    private static final String query =
            "select id, bookname, bookedition, bookprice from bookdata";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book",
                    "root", "123456");
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            out.println("<table border='1' align='center'>");
            out.println("<tr>");
            out.println("<th>Book Id</th>");
            out.println("<th>Book Name</th>");
            out.println("<th>Book Edition</th>");
            out.println("<th>Book Price</th>");
            out.println("<th>Edit</th>");
            out.println("<th>Delete</th>");
            out.println("</tr>");
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt(1) +"</td>");
                out.println("<td>" + rs.getString(2) +"</td>");
                out.println("<td>" + rs.getString(3) +"</td>");
                out.println("<td>" + rs.getFloat(4) +"</td>");
                out.println("<td><a href='edit?id=" + rs.getInt(1) + "'>Edit</a></td>");
                out.println("<td><a href='delete?id=" + rs.getInt(1) + "'>Delete</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (SQLException se) {
            se.printStackTrace();
            out.println("<h1>" + se.getMessage() + "</h1>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h1>" + e.getMessage() + "</h1>");
        }
        out.println("<a href='home.html'>Home</a>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}