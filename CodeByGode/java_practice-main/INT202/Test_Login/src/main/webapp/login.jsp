<%--
  Created by IntelliJ IDEA.
  User: sorra
  Date: 28/10/2566
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Login</h3>
<c:if test ="${messageLog != null}"> <p style="color: red">${messageLog}</p> </c:if>
<form action="login" method="post">
    Username:<input type="text" name="Username"> <br>
    Password:<input type="password" name="Password"> <br>
    <input type="submit" value="login">
    <a href="singup.jsp">Sing up</a>
</form>
</body>
</html>
