<%--
  Created by IntelliJ IDEA.
  User: nitisakkangkhan
  Date: 18/12/2023 AD
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="Login" method="post">
    Username <input type="text" name="user">
    password <input type="text" name="password">
    <input type="submit" value="submit">
    ${status}
</form>
</body>
</html>
