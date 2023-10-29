<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nawaphan
  Date: 28/10/2023 AD
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz</title>

</head>
<body>
<h1>Quiz</h1>
<form method="post" action="QuizController">
    <h2>${curQue.title}</h2>
    <c:forEach var="option" varStatus="i" items="${curQue.options}">
        <label>
            <input type="radio" name="options" value="${i.index}"> ${option}
        </label>
        <br>
    </c:forEach>
    <input type="submit" value="send">
</form>
</body>
</html>
