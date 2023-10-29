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
    <title>AddRemoveStudent</title>
</head>
<body>
<h1><%= "SitSpaceManagement" %></h1>
PAGE: <a href="AddRemoveStudent.jsp">ADD/REMOVE Student</a> | <a href="AllData.jsp">ALL DATA</a> <br>
<h3>Add Student Data</h3>
    <form action="Add" method="post">
        &nbsp;&nbsp;&nbsp;ID: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="id">&nbsp;Name: <input type="text" name="name"> <br><br>
        &nbsp;&nbsp;&nbsp;Score: <input type="text" name="score"> <br><br>
        &nbsp;&nbsp;&nbsp;<span style="color: red"><input type="submit" value="ADD"><c:if test="${messageError !=null}">&nbsp;${messageError}</c:if></span>
    </form>
<hr>
<h3>Remove Student </h3>
<form action="Remove" method="post">
    &nbsp;&nbsp;&nbsp;ID: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="id">&nbsp;&nbsp;<input type="submit" value="REMOVE">
</form>
<hr>
<c:if test="${message != null}"> <p style="color: red">${message}</p></c:if>
</body>
</html>
