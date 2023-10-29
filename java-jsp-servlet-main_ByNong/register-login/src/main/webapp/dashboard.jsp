<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>
</head>
<body>
<h2>Welcome ${sessionScope.user.username} to the Dashboard</h2>
<p>This is the user dashboard. You can add your dashboard content here.</p>
<a href="LoginServlet">Logout</a>
</body>
</html>