<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 27/10/2566
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="AddPostServlet" method="post">
        Title: <input type="text" name="title"><br>
        Content: <textarea name="content"></textarea><br>
        <input type="submit" value="Add Post">
    </form>
</body>
</html>
