<%--
  Created by IntelliJ IDEA.
  User: Phakp
  Date: 28/10/2566
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SitSpaceManagement</title>
</head>
<style>
    div{
        margin-top: 10px
    }

</style>
<body>
        <h1>SitSpaceManagement</h1><hr>
        <h1>Page : </h1>
        <a href="AddRemoveStudent.jsp">AddRemoveStudent</a>
        <a href="AllData.jsp">AllData</a>

        <hr>
        <h2>Add Student</h2>
        <form action="addServlet" method="post">
            <div>
                <label for="id">ID: </label>
                <input type="text" name="id" placeholder="ID">
            </div>
            <div>
                <label for="name">Name:</label>
                <input type="text" name="name" placeholder="Name">
            </div>
            <div>
                <label for="score">Score: </label>
                <input type="number" name="score" placeholder="Score">
            </div>
            <input type="submit" value="Add">
        </form>
        <hr>
        <h2>Remove Student</h2>
        <form action="RemoveServlet" method="post">
            <label for="id">ID: </label>
            <input type="text" name="studentId" placeholder="ID">
            <input type="submit" value="Remove">
        </form>

</body>
</html>I
