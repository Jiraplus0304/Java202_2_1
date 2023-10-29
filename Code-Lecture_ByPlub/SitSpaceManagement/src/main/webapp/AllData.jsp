<%--
  Created by IntelliJ IDEA.
  User: jiraplxs
  Date: 27/10/2023 AD
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--import java ผ่าน html--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AllData</title>
</head>
<body>
    <h1>SitSpaceManagement</h1>
    <h3>PAGE : <a href="AddServlet">ADD/REMOVE Student</a> | <a href="./AllData.jsp">Show All Data</a> </h3>
    <h3>All Data</h3>
    <table style="border: 1px solid black">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Score</th>
            <th>Grade</th>
        </tr>

<%--  ${} called el ไว้เขียน java อย่างง่าย / var ไว้เรียกใช้ตัวใน field (Student)--%>
        <c:forEach var="student" items="${useAll.students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.score}</td>
                <td>${student.calculateGrade()}</td>
            </tr>
        </c:forEach>


    </table>
</body>
</html>
