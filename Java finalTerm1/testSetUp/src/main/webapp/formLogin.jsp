<%--
  Created by IntelliJ IDEA.
  User: butte
  Date: 18/12/2023
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>

<body>


<form action="LoginServlet" method="post">
    username : <input type="text" placeholder="username" name="username">
    password : <input type="password" placeholder="password" name="password">

    <button type="submit" >Login</button>
</form>


<c:choose>
    <c:when test="${not empty requestScope.Error}">
        <p style="color: red;">${requestScope.Error}</p>
    </c:when>
</c:choose>
</body>
</html>
