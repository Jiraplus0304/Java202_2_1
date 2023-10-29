<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 30/8/2566
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AllData</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1 class="mb-4">SitSpaceManagement</h1>
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link" href="AddRemoveStudent.jsp">ADD/REMOVE student</a>
        </li>
        <li class="nav-item">
            <a class="nav-link active" href="AllData.jsp">Show All Data</a>
        </li>
    </ul>

    <h3 class="mt-5">All Data</h3>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>ID</th>
            <th>Name</th>
            <th>Score</th>
            <th>Grade</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sessionScope.allStudent.allData}" var="student" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.score}</td>
                <td>${student.calculateGrade}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
