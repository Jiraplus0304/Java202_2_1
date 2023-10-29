<%--
  Created by IntelliJ IDEA.
  User: jiraplxs
  Date: 30/10/2023 AD
  Time: 02:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>customerDetails</title>
</head>
<body>
        <h1>Customer Details</h1>
        <form action="customers" method = "post">
            <input type="hidden" name="action" value="updateCustomer">
            <input type="hidden" name="id" value="${requestScope.customer.id}">
            <label>Name</label>
            <input type="text" name = "name" value="${requestScope.customer.name}"><br>

            <label>Phone</label>
            <input type="tel" name = "phone" value="${requestScope.customer.phone}"><br>

            <input type="submit" value="Update Customer">
            <hr>
        </form>

        <h2>${requestScope.customer.id}</h2>
        <h2>${requestScope.customer.name}</h2>
        <h2>${requestScope.customer.phone}</h2>

        <form action="customers" method="post">
            <input type="hidden" name="action" value="deleteCustomer">
            <input type="hidden" name="id" value="${requestScope.customer.id}">
            <input type="submit" value="Delete">
        </form>

</body>
</html>
