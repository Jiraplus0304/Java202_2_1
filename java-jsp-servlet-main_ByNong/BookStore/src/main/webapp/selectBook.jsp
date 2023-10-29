<%@ page import="sit.int202.bookstore.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="sit.int202.bookstore.model.BookCatalog" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Phakp
  Date: 28/10/2566
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select Book</title>
</head>
<body>
<h1>Select Book</h1>
<form action="SelectBookServlet" method="post">
    <table border="1">
        <thead>
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>Year</th>
            <th>Select</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Book> books = BookCatalog.getInstance().getBooks();
            for (Book book : books) {
        %>
        <tr>
            <td><%= book.getTitle() %></td>
            <td><%= book.getAuthor() %></td>
            <td><%= book.getYear() %></td>
            <td>
                <input type="checkbox" name="selectedBooks" value="<%= book.getTitle() %>">
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <input type="submit" value="Add to History">
</form>
<a href="addBookForm.jsp">Add Book</a><br>
<a href="historyBook.jsp">View History Book</a><br>
</body>
</html>
