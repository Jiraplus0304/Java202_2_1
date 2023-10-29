<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 27/10/2566
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Blog Posts</h2>
    <c:forEach var="post" items="${posts}">
        <h3>${post.title}</h3>
        <p>${post.content}</p>
        <hr>
    </c:forEach>
</body>
</html>
