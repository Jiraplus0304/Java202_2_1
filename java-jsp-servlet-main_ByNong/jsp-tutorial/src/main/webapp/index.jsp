<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page errorPage="error_page.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1>Hello World</h1>

    <h1>Declaration Tag : </h1>
    <%! int a = 10; String name = "becoder"; %>
    <h1>Expression Tag: <%= a %> <%= name %> </h1>

    <%
        int sum = 20 + 30;
//        out.println("sum=" + sum)

        int sub = sum - 10;
//        out.println("sum=" + sub)
    %>

    <h1>Sum=<%=sum%></h1>
    <h1>Sub=<%=sub%></h1>

    <h1>Taglib Directive example</h1><hr>
    <c:set var="num" value="Be coder"></c:set>
    <c:out value="${name}"></c:out>

    <c:if test="${3 > 2}">
        <h1>True block</h1>
    </c:if>

    <% String name = "nong";
        name.length();
    %>
</body>
</html>