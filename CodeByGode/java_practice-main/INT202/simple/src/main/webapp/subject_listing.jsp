<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Phaksaweang
  Date: 9/4/2023
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subject List</title>
</head>
<body>
    <div class="flex-content" style="margin: 50px; background-color: beige">
        <hr>
        <h1>Subject List::</h1>
        <hr>
        <table>
            <tr style="background-color: beige;color: darkblue">
                <td>Subject Id</td>
                <td>Title</td>
                <td>Credit</td>
                <td>Select</td>
            </tr>
            <c:forEach var="subject" items="${subjects}" >
                <tr>
                    <td>${subject.id}</td>
                    <td>${subject.title}</td>
                    <td>${subject.credit}</td>
                    <td><input type="checkbox" value="${subject.id}"></td>
                </tr>
            </c:forEach>
        </table>
        <hr>
        <a href="/simple_war_exploded">Home</a>
        <hr>
    </div>

</body>
</html>
