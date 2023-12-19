<%--
  Created by IntelliJ IDEA.
  User: INT202&204
  Date: 11/7/2023
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<div class="container ml-2 p-2">
    <div class="d-flex flex-row">Product List ::</div>
    <hr>
    <c:forEach items="${products}" var="p" varStatus="vs">
    <div class="row">
        <div class="col-1">${vs.count + (page-1)*pageSize})</div>
        <div class="col-4"> ${p.productCode}: ${p.productName}</div>
        <div class="col-1"> ${p.productScale}</div>
        <div class="col-1" style="text-align: right">${p.price}</div>
    </div>
    </c:forEach>
    <hr>
    <div class="d-flex flex-row">
        <div>page: </div>
        <c:forEach begin="1" end="${itemCount/pageSize + (itemCount%pageSize>0?1 :0)}" varStatus="vs">
            <c:choose>
                <c:when test="${vs.count==page}">
                    <div class="p-1 text-danger">[${vs.count}]</div>
                </c:when>
                <c:otherwise>
                    <div class="p-1">
                        <a href="product-list?pageSize=${pageSize}&page=${vs.count}">[${vs.count}]</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>
</div>
</body>
</html>
