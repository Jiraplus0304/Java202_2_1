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
    <title>Result</title>
</head>
<c:set var="score" value="${quizSession.correctAnswersCount}"/>
<c:set var="allScore" value="${quizSession.questions.size()}"/>
<body>
Good! this is your score <br>
${score}/${allScore}

<a href="ResetQuizServlet">Reset</a>
</body>
</html>
