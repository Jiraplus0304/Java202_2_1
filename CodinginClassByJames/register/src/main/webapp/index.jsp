<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<c:set var="bg_color" scope="session" value="${cookie.bg_color_cookie.value}"/>
<body style="background-color: ${bg_color}">
    Session Id: ${cookie.JSESSIONID.value}
    <h2>Menu</h2><hr>
    <a href="course-list">ลงทะเบียน</a><br>
    <a href="course-registered-history">ประวัติลงทะเบียน</a><br>
    ---------------------------------------<br>
    <a href="set-theme">Select Your Theme</a><br>
    ---------------------------------------<br>
    <a href="">Logout</a>
</body>
</html>