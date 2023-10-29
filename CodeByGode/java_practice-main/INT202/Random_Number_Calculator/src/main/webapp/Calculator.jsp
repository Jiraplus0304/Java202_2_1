<%--
  Created by IntelliJ IDEA.
  User: sorra
  Date: 29/10/2566
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Addition Quiz Status :  ${count}/${countTotal}</h1>
<form action="calculator" method="post">
        What is ${num1} + ${num2} =
        <input type="text" name="answer">
        <input type="submit" value="Submit">
</form>
<hr>
<c:if test="${message != null}">
    <h3>${message}</h3>
</c:if>
</body>
</html>
