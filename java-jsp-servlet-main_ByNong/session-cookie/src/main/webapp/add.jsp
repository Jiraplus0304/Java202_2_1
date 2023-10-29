<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 27/10/2566
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="cyan">
    <%
        int i = Integer.parseInt(request.getParameter("num1"));
        int j = Integer.parseInt(request.getParameter("num2"));

        int k = i + j;

        out.println("Output: " + k);
    %>
</body>
</html>
