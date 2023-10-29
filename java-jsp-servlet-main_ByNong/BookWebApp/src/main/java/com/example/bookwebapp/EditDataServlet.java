package com.example.bookwebapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "EditDataServlet", value = "/edit")
public class EditDataServlet extends HttpServlet {
    private static final String query =
            "select bookname, bookedition, bookprice from bookdata where id = ?";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book",
                    "root", "123456");
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            out.println("<form action='editUrl?id=" + id + "' method='post'>");
            out.println("<table align='center'>");
            out.println("<tr>");
            out.println("<td>Book Name</td>");
            out.println("<td><input type='text' name='bookName' value='"+ rs.getString(1) +"'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Book Edition</td>");
            out.println("<td><input type='text' name='bookEdition' value='"+ rs.getString(2) +"'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>Book Price</td>");
            out.println("<td><input type='text' name='bookPrice' value='"+ rs.getString(3) +"'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><input type='submit' value='Edit'</td>");
            out.println("<td><input type='reset' value='Cancel'</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
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