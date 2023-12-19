<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1>login
</h1>
<h1>Hello ${CurCustomer == null ?  "Guest" : CurCustomer.customerName}!</h1>

<c:choose>
    <c:when test="${CurCustomer == null}">
        <a href="./login.jsp">Login</a>
    </c:when>
    <c:otherwise>
        <a href="logout">Logout</a>
    </c:otherwise>
</c:choose>

<c:if test='${CurCustomer != null}'>
<c:forEach var="order" items="${orders}"></c:forEach>
</c:if>


</body>
</html>