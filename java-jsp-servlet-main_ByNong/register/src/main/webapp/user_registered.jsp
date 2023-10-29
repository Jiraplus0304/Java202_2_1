<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 10/2/2023
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Course History</title>
</head>
<body>
    <h2>Course Register History (Session)</h2>
    <c:if test="${message != null}">
        <h2 style="color: red; background-color: yellow">
            ${message} <br><hr>
            <a href="course-list"><button>OK</button></a>
        </h2>
    </c:if>
    <c:if test="${message == null}">
        <c:forEach items="${courseRegistered.history}" var="enry">
            <c:forEach items="${enry.value}" var="subject" varStatus="vs">
                ${vs.count}) ${subject.subjectId} ${subject.title} ${subject.credit}<hr>
            </c:forEach>
            <br>
        </c:forEach>
        <hr>
        <a href="index.jsp"><button>OK</button></a>
    </c:if>
</body>
</html>
