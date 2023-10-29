<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="flex-content" style="margin: 100px; background-color: bisque">
    <h1>Subject List::</h1>
    <hr>
    <table>
        <tr style="background-color: bisque;color: darkblue">
            <td>Subject Id</td>
            <td>Title</td>
            <td>Credit</td>
        </tr>
        <c:forEach var="subject" items="${subjects}">
            <tr>
                <td>${subject.id}</td>
                <td>${subject.title}</td>
                <td>${subject.credit}</td>
                <td><input type="checkbox" value="${subject.id}"></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>