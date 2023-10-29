<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body style="background-color:${cookie.bg_color.value}">
<div class="container">
    <div class="row">
        <div class="col-12">
            <h2 style="color: ${cookie.bg_color.value == "#2b2b2b" ? "aliceblue":"" }">Menu</h2>
            <hr style="background-color: ${cookie.bg_color.value == "#2b2b2b" ? "aliceblue":"" }">
            <a href="course-list">ลงทะเบียน</a><br>
            <a href="course-registered-history">ประวัติลงทะเบียน</a><br>
            <a href="set_theme"> Set Theme </a><br>
        </div>
    </div>
</div>
</body>
</html>
</html>
