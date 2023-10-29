<%@ page import="sit.int202.bookstore.model.Book" %>
<%@ page import="sit.int202.bookstore.model.BookCatalog" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Phakp
  Date: 28/10/2566
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
<h1>Book List</h1>
<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Year</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Book> books = BookCatalog.getInstance().getBooks();
        for (Book book : books) {
    %>
    <tr>
        <td><%= book.getTitle()%></td>
        <td><%= book.getAuthor() %></td>
        <td><%= book.getYear()%></td>


    </tr>
    <%
        }
    %>
    </tbody>
</table>
<a href="addBookForm.jsp">Add Book</a><br>
<a href="index.jsp">Home</a>
</body>
</html>
