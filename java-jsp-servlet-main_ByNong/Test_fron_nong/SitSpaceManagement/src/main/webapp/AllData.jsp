<%--
  Created by IntelliJ IDEA.
  User: Phakp
  Date: 28/10/2566
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="sit.int207.sitspacemanagement.model.*" %>
<html>
<head>
    <title>SitSpaceManagement</title>
</head>
<body>

<h1>SitSpaceManagement</h1><hr>
<h1>Page : </h1>
<a href="AddRemoveStudent.jsp">AddRemoveStudent</a>
<a href="AllData.jsp">AllData</a>
<hr>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Score</th>
        <th>Grade</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Student> students = AllStudent.getInstance().getStudents();
        for (Student student : students) {
    %>
    <tr>
        <td><%= student.getId() %></td>
        <td><%= student.getName() %></td>
        <td><%= student.getScore() %></td>
        <td><%= student.getGrade() %></td>

    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
