<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body style="background-color: ${cookie.bg_cookie.value}">
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a> <br>
<a href="favorite_subject.html">Favorite Subject</a> <br>
<a href="EvalGrade.html">EvalGrade</a><br>
<a href="SubjectList">SubjectList</a><br>
<a href="test_cookie">Test_cookie</a><br>
<a href="multiplication_table">Multiplication</a>

</body>
</html>