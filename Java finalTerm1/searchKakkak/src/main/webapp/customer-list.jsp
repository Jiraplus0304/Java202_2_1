<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nawaphan
  Date: 19/12/2023 AD
  Time: 01:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<form method="post" action="search-customer">
  Search: <input type="text" name="search-input">
  <input type="submit">

    <table>
        <tr>
            <th>customerNumber</th>
            <th>customerName</th>
            <th>contactFirstName</th>
            <th>contactLastName</th>
            <th>postalCode</th>
            <th>creditLimit</th>
        </tr>
        <c:forEach var="c" items="${customers}">
        <tr>
            <td>${c.customerNumber}</td>
            <td>${c.customerName}</td>
            <td>${c.contactFirstName}</td>
            <td>${c.contactLastName}</td>
            <td>${c.postalCode}</td>
            <td>${c.creditLimit}</td>
        </tr>
        </c:forEach>

    </table>

</form>
</body>
</html>
