<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 30/8/2566
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSP expression</h1>
<p>Calling a method: <%= Math.addExact(2, 3) %></p>
<p>Evaluating a boolean: <%= "bob".length() < 3 %></p>
<p>Math expression: <%= (500.6 * 7) - 50%></p>
<p>Java object: <%= new Date() %></p>
</body>
</html>
