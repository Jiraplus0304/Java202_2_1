<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 29/10/2566
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Applications</title>
</head>
<body>

<c:if test="${error != null}">
    <h2>Error: ${error}</h2>
</c:if>

<form action="applications" method="post">
    <input type="text" name="action" value="apply" hidden>

    <label for="firstName">First Name</label>
    <input type="text" name="firstName" id="firstName" placeholder="First Name">

    <label for="lastName">Last Name</label>
    <input type="text" name="lastName" id="lastName" placeholder="Last Name">

    <label for="email">Email</label>
    <input type="email" name="email" id="email" placeholder="Email">

    <label for="jobPosition">Job ID</label>
    <select name="jobPosition" id="jobPosition">
        <c:forEach items="${jobPositions}" var="pos">
            <option value="${pos}">${pos}</option>
        </c:forEach>
    </select>

    <input type="submit" value="Apply">
</form>

<hr>

<form action="applications" method="post">
    <input type="text" name="action" value="delete" hidden>

    <label for="id">Application ID</label>
    <input type="text" name="id" id="id" placeholder="Application ID">

    <label for="password">Password</label>
    <input type="password" name="password" id="password" placeholder="Password">

    <input type="submit" value="Delete">
</form>

<hr>

<table>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Job Position</th>
    </tr>
    <c:forEach items="${applications}" var="app">
        <tr>
            <td>${app.id}</td>
            <td>${app.firstName}</td>
            <td>${app.lastName}</td>
            <td>${app.email}</td>
            <td>${app.jobPosition}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
