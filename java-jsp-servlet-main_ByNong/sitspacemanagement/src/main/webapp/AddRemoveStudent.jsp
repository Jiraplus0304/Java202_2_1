<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 30/8/2566
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD/REMOVE student</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="mb-4">SitSpaceManagement</h1>
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" href="AddRemoveStudent.jsp">ADD/REMOVE Student</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="AllData.jsp">Show All Data</a>
        </li>
    </ul>

    <h3 class="mt-5">Add Student Data</h3>
    <form action="AddServlet" method="POST">
        <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" class="form-control" name="id" required>
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" name="name" required>
        </div>
        <div class="form-group">
            <label for="score">Score:</label>
            <input type="text" class="form-control" name="score" required>
        </div>
        <button type="submit" class="btn btn-primary">ADD</button>
    </form>
    <hr>

    <h3>Remove Student Data</h3>
    <form action="RemoveServlet" method="POST">
        <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" class="form-control" name="id" required>
        </div>
        <button type="submit" class="btn btn-danger">REMOVE</button>
    </form>
    <hr>

    <h3>${message}</h3>
</div>
</body>
</html>
