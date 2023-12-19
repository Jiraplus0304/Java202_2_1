<%--
  Created by IntelliJ IDEA.
  User: butte
  Date: 18/12/2023
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employees List</title>
</head>
<body>
    <c:forEach items="${employees}" var="employee">
        <h3> ${employee.firstName} ${employee.lastName} ${employee.email}</h3>
    </c:forEach>
</body>
</html>
