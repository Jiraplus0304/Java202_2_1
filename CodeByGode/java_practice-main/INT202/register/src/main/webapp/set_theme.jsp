<%--
  Created by IntelliJ IDEA.
  User: Phaksaweang
  Date: 6/10/2566
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select Your theme</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container" >
    <h2>Select Your theme</h2>
    <form action="set_theme" method="post">
        <div>
            <input type="radio" name="bg_color" value="#fff" id="light">
            <label for="light">Light</label>
        </div>
        <div>
            <input type="radio" name="bg_color" value="#2b2b2b" id="dark">
            <label for="dark">Dark</label>
        </div>
        <div>
            <input type="submit" value="Submit">
        </div>
    </form>
</div>
</body>
</html>
