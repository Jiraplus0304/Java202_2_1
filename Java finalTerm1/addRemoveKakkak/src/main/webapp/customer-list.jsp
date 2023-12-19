index.jsp
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
<form action="add-remove-customer" method="post">ADD
    customerNumber:<input type="text" name="customerNumber">
    customerName:<input type="text" name="customerName">
    contactLastName:<input type="text" name="contactLastName">
    contactFirstName:<input type="text" name="contactFirstName">
    phone:<input type="text" name="phone">
    addressLine1:<input type="text" name="addressLine1">
    addressLine2:<input type="text" name="addressLine2">
    city:<input type="text" name="city">
    state:<input type="text" name="state">
    postalCode:<input type="text" name="postalCode">
    country:<input type="text" name="country">
    creditLimit:<input type="text" name="creditLimit">
    <input type="submit" value="insert">
</form>
<table>
    <tr>
        <th>customerNumber</th>
        <th>customerName</th>
        <th>contactFirstName</th>
        <th>contactLastName</th>
        <th>postalCode</th>
        <th>creditLimit</th>
        <th>phone</th>
        <th></th>
    </tr>
    <c:forEach var="c" items="${customers}">
        <tr>
            <td>${c.customerNumber}</td>
            <td>${c.customerName}</td>
            <td>${c.contactFirstName}</td>
            <td>${c.contactLastName}</td>
            <td>${c.postalCode}</td>
            <td>${c.creditLimit}</td>
            <td>${c.phone}</td>
            <td><a href="add-remove-customer?id=${c.customerNumber}">X</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
