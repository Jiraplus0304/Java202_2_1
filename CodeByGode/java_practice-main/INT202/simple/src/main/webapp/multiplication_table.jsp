
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>MultiplicationTable</title>
</head>
<body>
<h1>MultiplicationTable</h1>

<form action="multiplication_table" method="get">
    number <input type="text" name="number">
    <input type="submit" value="Submit">
</form>
    <c:if test="${error == null && param.number != null}" >
        <table>
            <tr>
                <td colspan="5">MT for ${param.number}</td>
            </tr>

        <c:forEach begin="1" end="12" var="n">
            <c:choose>
                <c:when test="${n%3==1}">
                    <c:set var ="bg" scope="page" value="white"/>
                </c:when>
                <c:when test="${n%3==2}">
                    <c:set var ="bg" scope="page" value="lightgray"/>
                </c:when>
                <c:otherwise>
                    <c:set var ="bg" scope="page" value="gray"/>
                </c:otherwise>
            </c:choose>
            <tr>
                <td> ${param.number}</td>
                <td> x </td>
                <td> ${n}</td>
                <td> = </td>
                <td> ${param.number * n}</td>
            </tr>
        </c:forEach>
       </table>
    </c:if>

    <c:if test="${error != null}" >
    Error: ${requestScope.error}
        ${error == null || param.number == "" ? "Empty/null" : param.number}
    </c:if>



</body>
</html>
