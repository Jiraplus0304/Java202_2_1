<%--
  Created by IntelliJ IDEA.
  User: INT202&204
  Date: 9/25/2023
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Cookie</title>
</head>
<body style="background-color: ${bgColor}">
<h1>Test Cookies</h1>
<hr>
<form action="test_cookie" method="post">
    Please select your theme: <br>
    &nbsp; &nbsp; &nbsp; - <input type="radio" name="bg" value="darkblue"
    ${bgColor == 'darkblue' ? 'checked' : ''}> Dark Blue <br>
    &nbsp; &nbsp; &nbsp; - <input type="radio" name="bg" value="yellow"
    ${bgColor == 'yellow' ? 'checked' : ''}> Yellow <br>
    &nbsp; &nbsp; &nbsp; - <input type="radio" name="bg" value="gray"
    ${bgColor == 'gray' ? 'checked' : ''}> Gray <br>
    <input type="submit">
</form>
<br><br>
<a href="index.jsp">Goto Home Page</a>
</body>
</html>
