<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 30/8/2566
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSP Scriptlet Tags</h1>
<%-- This is how you make a JSP comment --%>
<%
    double myTestScore = 100.0;
    myTestScore = myTestScore - 50.0;
%>
<p>My real test score: <%= myTestScore %>
</p>

<%
    if (1 + 1 == 2) { %>
<p>One plus one is indeed equal to two</p>
<% } else { %>
<p>Nevermind im a dumbo</p>
<% } %>
</body>
</html>
