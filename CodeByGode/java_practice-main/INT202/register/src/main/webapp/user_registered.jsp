<%--
  Created by IntelliJ IDEA.
  User: Phaksaweang
  Date: 2/10/2566
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RegisterHistory</title>
    <%--<link rel="stylesheet" type="text/css" href="assets/bootstrap-4.5/css/bootstrap.min.css"/>--%>
<%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"--%>
<%--          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%--        <c:forEach items="${courseRegistered.history}" var="entry">--%>
<%--            <h3>Semester ${semesters[entry.key]}</h3>--%>
<%--            <c:forEach items="${entry.value}" var="subject" varStatus="vs">--%>
<%--                ${vs.count} ${subject.subjectId} ${subject.title} ${subject.credit}--%>
<%--            </c:forEach>--%>
<%--        </c:forEach>--%>
<div class="container">
    <div class="row">
        <div class="col-12">
            <h1>Register History</h1>
            <c:if test="${message != null}">
                <hr>
                <div class="alert alert-success" role="alert">
                        ${message}
                </div>
                <a href="course-list">
                    <button class="btn btn-primary">OK</button>
                </a>
            </c:if>
            <c:if test="${message==null}">
                <table class="table table-striped">
                    <c:forEach items="${courseRegistered.history}" var="entry">
                        <thead>
                        <tr>
                            <th scope="row" colspan="3">Semester: ${semesters[entry.key]}</th>
                        </tr>
                        <tr>
                            <th scope="col">Subject ID</th>
                            <th scope="col">Subject Name</th>
                            <th scope="col">Credit</th>
                        </tr>
                        </thead>
                        <c:forEach items="${entry.value}" var="subject" varStatus="vs">
                            <tbody>
                            <tr>
                                <td>${subject.subjectId}</td>
                                <td>${subject.title}</td>
                                <td>${subject.credit}</td>
                            </tr>
                            </tbody>
                        </c:forEach>
                    </c:forEach>
                </table>
                <div><a href="index.jsp" class="btn btn-primary">Back</a></div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
