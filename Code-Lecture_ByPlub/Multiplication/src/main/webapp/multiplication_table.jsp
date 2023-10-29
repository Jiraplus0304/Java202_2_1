<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29/10/2566
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Multiplication Table</title>
    <style>
        td{
            border-spacing: 0px;
            padding: 0px 15px 0px 15px;
            height: 16px;
            text-align: center;
        }
        table {
            border: 1px solid darkcyan;
        }
        number {
            text-align: right;
            padding-right: 15px;
        }
    </style>
</head>
<body>
<h1>Multiplication Table</h1>
<hr>
<c:if test="${error == null}">
 <table>
     <tr>
         <td colspan="5" style="background-color: aquamarine">Multiplication Table of ${param.number}</td>
     </tr>
 <c:forEach begin="1" end="12" var="n">
     <c:choose>
         <c:when test="${n%3==1}">
             <c:set var="bg" scope="page" value="white"/>
         </c:when>
         <c:when test="${n%3==2}">
             <c:set var="bg" scope="page" value="lightgray"/>
         </c:when>
         <c:otherwise>
             <c:set var="bg" scope="page" value="gray"/>
         </c:otherwise>
     </c:choose>
     <tr style="background-color: ${bg}">
         <td class="number"> ${param.number}</td>
         <td> x </td>
         <td class="number"> ${n}</td>
         <td> = </td>
         <td class="number"> ${n * param.number}</td>
     </tr>
 </c:forEach>
 </table>
</c:if>
<c:if test="${error != null}">
<h3 style="color: red">
    Error:${error}
    (${param.number != null || param.number == '' ? param.number : "Null/Empty"})
</h3>
</c:if>
<hr>
Your Browser: ${header['User-Agent']}
</body>
</html>
