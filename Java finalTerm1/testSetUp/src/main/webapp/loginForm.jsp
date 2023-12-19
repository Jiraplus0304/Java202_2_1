<%--
  Created by IntelliJ IDEA.
  User: butte
  Date: 19/12/2023
  Time: 1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login </title>
</head>
<body>
<%--ต้องใส่ต่รงนี--%>
    <form action="${pageContext.request.contextPath}/041/loginDbServlet" method="post">
        Username: <input type="text" name="username">
        password: <input type="password" name="password">
        <input type="submit" value="login">
    </form>

<c:choose>
    <c:when test="${error != null}">
        <p>${error}</p>
    </c:when>
</c:choose>


<c:choose>
    <c:when test="${checkCorrect != null}">
        <p> ${checkCorrect}</p>
    </c:when>
</c:choose>


<%--<c:choose>--%>
<%--    <c:when test="${display-name != null}">--%>
<%--        <p> ${display-name}</p>--%>
<%--    </c:when>--%>
<%--</c:choose>--%>

</body>
</html>
