<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 28/10/2566
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Remove</title>
</head>
<body>
<h1>
    Add Remove
</h1>

<form action="add" method="post">
    <input type="number" name="id" placeholder="id">
    <input type="text" name="name" placeholder="name">
    <input type="number" name="score" placeholder="score">
    <button type="submit">
        Add
    </button>
</form>

<form action="remove" method="post">
    <input type="number" name="id" placeholder="id">
    <button type="submit">
        Remove
    </button>
</form>

<c:forEach items="${applicationScope.studentContext.all}" var="student">
    <p>
            ${student.id} ${student.name} ${student.grade}
    </p>
</c:forEach>

<c:if test="${message != null}">
    <p>
            ${message}
    </p>
</c:if>

</body>
</html>
