<%--
  Created by IntelliJ IDEA.
  User: Phakp
  Date: 28/10/2566
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove</title>
</head>
<body>
<h1>Remove Book</h1>
    <form action="RemoveBook" method="post">
        <label for="title">Title: </label>
            <input type="text" name="title"  >
            <input type="submit" value="Remove">
    </form>
</body>
</html>
