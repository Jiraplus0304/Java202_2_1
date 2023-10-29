<%--
  Created by IntelliJ IDEA.
  User: INT202&204
  Date: 9/26/2023
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<c:set var="bg_color" scope="session" value="${cookie.bg_color_cookie.value}"/>
<body style="background-color: ${bg_color}">
<h2>Course Registered</h2>
<c:if test="${message!=null}">
    <h3 style="color: red">${message}</h3>
    <c:set var="link" value="course-list"/>
</c:if>
<c:if test="${message==null}">
    <c:forEach items="${courseRegistered.history}" var="entry">
        <h3> ${semesters[entry.key]}</h3><hr>
        <c:forEach items="${entry.value}" var="subject">
            ${subject.subjectId}, ${subject.title}, ${subject.credit}<br>
        </c:forEach>
        ---------------------------------------<br><br>
    </c:forEach>
    <c:set var="link" value="index.jsp"/>
</c:if>
<hr>
<a href="${link}"><button>OK</button></a>
</body>
</html>
