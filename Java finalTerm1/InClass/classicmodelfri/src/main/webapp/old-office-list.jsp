<%--
  Created by IntelliJ IDEA.
  User: 9inejames
  Date: 7/11/2023 AD
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Office-Employee List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
    .btn-pink {
        background-color: bisque;
    }

    .btn-pink:hover {
        background-color: rosybrown;
        color: beige;
    }

    .tr {
        color: brown;
    }

    .pen {
        color: mediumseagreen;
    }
</style>
<body>
<div class="container">
    <div class="row bg-info pt-2 pb-2">
        <div class="col-8 mt-2">
            <h2>
                <a href="office-list">
                    <button class="btn btn-lg mt-0 pt-0" style="font-size: larger">
                        <i class="fa fa-home"></i>
                    </button>
                </a>
                Classic Model Offices ::
            </h2>
        </div>
        <div class="col-4 mt-2 mb-0 pb-0">
            <form action="office-list" method="get" class="form-inline">
                <input type="text" class="form-control" name="search" placeholder="Type country or city"
                       value="${search}">
                <button type="submit" class="btn btn-pink ml-2">SEARCH</button>
            </form>

        </div>
    </div>

    <div class="row d-flex ">
        <%--        office list--%>
        <c:forEach items="${offices}" var="office">
            <div class="col-2 border border-secondary p-2 m-2 rounded
        ${office.officeCode == selectedOffice.officeCode ? 'border-success bg-warning' : ''}">
                <div class="d-inline d-flex flex-row justify-content-around align-items-center">
                    <h4 class="bold text-info mt-2"> OFFICE ${office.officeCode}</h4>

                    <form action="office-list" method="post" class="p-0 m-0">
                        <input type="hidden" name="delete" value="${office.officeCode}">
                        <button type="submit" class="btn btn-lg tr p-0 m-0"><i class="fa fa-trash"></i></button>
                    </form>

                        <%--                    update--%>
                    <form action="update-office" method="get" class="p-0 m-0">
                        <input type="hidden" name="update" value="${office.officeCode}">
                        <button type="submit" class="btn btn-lg pen p-0 m-0"><i class="fa fa-pencil"></i></button>
                    </form>
                </div>

                <div>
                    <a href="office-list?officeCode=${office.officeCode}"> ${office.city} </a>, ${office.country}
                </div>
                <div> ${office.phone}</div>

            </div>
        </c:forEach>
        <div class="col-12 d-flex flex-row-reverse">
            <div>
                <a href="add-office" class="btn btn-pink">ADD NEW OFFICE</a>
            </div>
        </div>
    </div>
    <br>

    <div class="row bg-light"><b>Employees ::</b></div>
    <div class="row">
        <c:forEach items="${selectedOffice.employeeList}" var="employee">
            <div class="col-2 pl-2 m-2 border border-secondary rounded-pill">
                <div> ${employee.firstName}
                        ${employee.lastName} - ${employee.jobTitle}
                </div>
            </div>
        </c:forEach>
    </div>
    <hr>


</div>
</body>
</html>
