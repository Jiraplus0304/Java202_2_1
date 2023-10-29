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
<a href="hello-servlet">Hello Servlet</a>
<form action="add.jsp">
    <label>Enter 1st number : </label><input name="num1" type="text" />
    <label>Enter 2st number : </label><input type="text" name="num2" />
    <input type="submit">
</form>
</body>
</html>