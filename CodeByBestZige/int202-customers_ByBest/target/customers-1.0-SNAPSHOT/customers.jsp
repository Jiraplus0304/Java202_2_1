<%--
  Created by IntelliJ IDEA.
  User: jiraplxs
  Date: 30/10/2023 AD
  Time: 02:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- c ช่วยเขียน logic ใน html JSTL--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer</title>
</head>
<body>
<div>
    <h1>Add Customer</h1>
<%-- action ไปที่ customers  --%>
    <form action="customers" method = "post">
        <input type="hidden" name="action" value="addCustomer">
        <label>Name</label>
        <input type="text" name = "name"><br>

        <label>Phone</label>
        <input type="tel" name = "phone"><br>

        <input type="submit" value="submit">
        <hr>
    </form>
</div>

<div>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Details</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${applicationScope.customers}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.phone}</td>
                <td>
                    <a href="customers?id=${customer.id}">
                        Details
                    </a>
                </td>
                <td>
                    <form action="customers" method="post">
                        <input type="hidden" name="action" value="deleteCustomer">
                        <input type="hidden" name="id" value="${customer.id}">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>

        </c:forEach>
    </table>
</div>
</body>
</html>
