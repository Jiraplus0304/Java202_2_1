<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nawaphan
  Date: 18/12/2023 AD
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form method="post" action="login">
    username : <input type="text" name="username"/> <br>
    password : <input type="password" name="password"/>
    <br><input type="submit" value="login">
</form>
<p style="color: red">${status}</p>




</body>
</html>
