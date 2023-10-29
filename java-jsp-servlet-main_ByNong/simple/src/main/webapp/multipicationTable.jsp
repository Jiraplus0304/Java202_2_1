<%--
  Created by IntelliJ IDEA.
  User: INT202&204
  Date: 9/18/2023
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Multipication Table of ${param.number}</h2><hr>
    <c:if test="${message == null}">
        <table style="border: 1px solid darkcyan; text-align: right">
            <tr style="background-color: darkcyan"><td colspan="5">${param.number}</td></tr>
            <c:forEach begin="1" end="12" var="n">
                <tr>
                    <td> ${param.number} </td>
                    <td> x </td>
                    <td> ${n} </td>
                    <td> = </td>
                    <td> ${n * param.number}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${message != null}">
        <h3 style="color:red">Error::
        <hr>
        <span style="color:black"> ${message} </span> (${param.number==null ? 'null' : param.number})</h3>
    </c:if>
</body>
</html>
