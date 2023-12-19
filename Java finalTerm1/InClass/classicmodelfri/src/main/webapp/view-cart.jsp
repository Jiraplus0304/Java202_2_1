<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 11/17/2023
  Time: 12:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${cart == null} || empty cart.allitem">
        <h3 class="text-danger">No item in your shopping cart</h3>
    </c:when>

<c:otherwise>
    <table class="table table-striped table-bordered w-100">
        <thead>
        <th>#</th>
        <th>Code</th>
        <th>Code</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Total</th>
        </thead>
        <tbody>
        <c:forEach  items="${cart.allItem}" var="lineItem" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${lineItem.product.productCode}</td>
                <td>${lineItem.product.productName}</td>
                <td>${lineItem.quantity}</td>
                <td>${lineItem.product.price}</td>
                <td>${lineItem.total}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="5" style="text-align: right; margin-right: 5px">Total</td>
            <td>${cart.totalPrice}</td>
        </tr>
        </tbody>
    </table>
</c:otherwise>
</c:choose>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
