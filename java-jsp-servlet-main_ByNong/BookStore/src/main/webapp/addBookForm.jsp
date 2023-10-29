<%--
  Created by IntelliJ IDEA.
  User: Phakp
  Date: 28/10/2566
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a Book</title>
</head>
<body>
<h1>Add a Book</h1>
<form action="addBook" method="post">
    <div>
        <label for="title">Title: </label>
        <input type="text" name="title" required>
    </div>
    <div>
        <label for="author">Author: </label>
        <input type="text" name="author" required>
    </div>
    <div>
        <label for="year">Year: </label>
        <input type="number" name="year" required>
    </div>
    <input type="submit" value="AddBook">
</form>
<a href="bookList.jsp">View Book List</a><br>
<a href="addBookForm.jsp">AddBookForm</a>><br>
<a href="index.jsp">Home</a>

</body>
</html>
