<%--
  Created by IntelliJ IDEA.
  User: sorra
  Date: 28/10/2566
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ALL DATA</title>
    <style>
        table {
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1><%= "SitSpaceManagement" %></h1>
PAGE: <a href="AddRemoveStudent.jsp">ADD/REMOVE Student</a> | <a href="AllData.jsp">ALL DATA</a>
<hr>
<table style="width:500px">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Score</th>
        <th>Grade</th>
    </tr>
    <c:forEach items="${findAll}" var="student">
    <tr>
        <td>${student.key}</td>
        <td>${student.value.name}</td>
        <td>${student.value.score}</td>
        <td>${student.value.grade}</td>
    </tr>
    </c:forEach>
</body>
</html>
