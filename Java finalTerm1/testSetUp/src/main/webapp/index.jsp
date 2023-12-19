<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>

<a href="employeeListServlet">employee List</a><br>
<a href="041/loginDbServlet">Register</a><br>
<a href="${pageContext.request.contextPath}/041/loginDbServlet">Login</a>

</body>
</html>