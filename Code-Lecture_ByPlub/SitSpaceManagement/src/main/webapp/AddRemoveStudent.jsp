<%--
  Created by IntelliJ IDEA.
  User: jiraplxs
  Date: 27/10/2023 AD
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddRemoveStudent</title>
</head>
<body>
        <h1>SitSpaceManagement</h1>
        <h3>PAGE : <a href="AddServlet">ADD/REMOVE Student</a> | <a href="./AllData.jsp">All Data</a></h3>
        <form action="AddServlet" method="post">
            <h3>Add Student Data</h3>
            <p>ID: <input type="text" name="id"></p><p>Name: <input type="text" name="name"></p>
            <p>Score: <input type="text" name="score"></p>
            <input type="submit" value="ADD">
            <hr>
        </form>
        <form action="RemoveServlet" method="post">
            <h3>ID: <input type="text" name="id"> <input type="submit" value="REMOVE"></h3>
            <hr>
        </form>
        <%--  ${} called el ไว้เขียน java อย่างง่าย / เรียก key ที่อยู่ใน AddServlet--%>
        <p> ${addedStatus} </p>
        <p> ${removedStatus} </p>
</body>
</html>
