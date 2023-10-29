<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 29/10/2566
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<h1>Profile Session</h1>
<h2>
    Username: ${sessionScope.user.username}<br>
</h2>
<h2>
    Password: ${sessionScope.user.password}<br>
</h2>

<form action="logout" method="post">
    <input type="submit" value="Logout" formaction="logout">
</form>
</body>
</html>
