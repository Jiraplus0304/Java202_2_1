<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History Book</title>
</head>
<body>
<h1>History Book</h1>
<ul>
    <%
        List<String> historyBooks = (List<String>) request.getSession().getAttribute("historyBooks");
        if (historyBooks != null) {
            for (String book : historyBooks) {
    %>
    <li><%= book %></li>
    <%
            }
        }
    %>
</ul>
<a href="selectBook.jsp">Select More Books</a><br>
<a href="addBookForm.jsp">Add Book</a><br>
</body>
</html>
