<%--
  Created by IntelliJ IDEA.
  User: Phaksaweang
  Date: 25/9/2566
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-color:${bgColor} ">
    <h1>Test Cookie</h1>
    <hr>
    <form action="test_cookie" method="post">
        &nbsp; &nbsp; &nbsp;<input type="radio" name="bg" value="darkblue"> Dark Blue <br>
        &nbsp; &nbsp; &nbsp;<input type="radio" name="bg" value="yellow"> Yellow <br>
        &nbsp; &nbsp; &nbsp;<input type="radio" name="bg" value="gray"> Gray <br>
        &nbsp; &nbsp; &nbsp; <input type="submit">
    </form>
</body>
</html>
