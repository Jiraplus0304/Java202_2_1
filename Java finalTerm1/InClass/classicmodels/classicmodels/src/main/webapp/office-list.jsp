<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Classic Model Online</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.1/font/bootstrap-icons.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha384-o3N3F5p6f7JjFjvYO5W7lO2Xz3H6J95bMZW5WceYvXpMFFqtkx4OHJhET32W6D3T" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body class="container">
<div class="m-3 border-2 shadow p-3 mb-5 bg-body-tertiary rounded ">
  <div class="row bg-warning border border-dark border-5" >
    <h2 class=" mx-2">Welcome to the back office management by Jiraplus Chanpong 011</h2>
    <h3 class=" mx-2">You can manage everything below here!!!</h3>
  </div>
  <div class="row">
    <div class="row">
      <form class="input-group col-3" action="office-list" method="get">
        <input type="text" class="form-control m-2 col-10" name="cityOrCountry" placeholder="Search">
        <button class="btn btn-success m-2 col-2">
          <i class="fas fa-search"></i> Search
        </button>
        <a href="office-action" class="btn btn-danger m-2 col-2">
          <i class="bi bi-plus"></i> Add Office
        </a>
      </form>
    </div>
    <c:forEach items="${offices}" var="office">
      <div class="div-link col-4 border border-secondary p-2 m-2 ${office.officeCode == selectedOffice.officeCode ? 'bg-warning' : ''}">
        <div>${office.city}, ${office.country}</div>
        <div>${office.phone}</div>
        <div class="d-flex">
          <form action="office-action" method="get" class="m-2 col-2">
            <input type="hidden" name="action" value="update" />
            <input type="hidden" name="officeCode" value="${office.officeCode}" />
            <button type="submit" class="btn btn-info text-white">
              <i class="bi bi-pencil-square"></i> Edit
            </button>
          </form>


          <form action="office-action" method="post" class="m-2 col-2">
            <input type="hidden" name="action" value="delete" />
            <input type="hidden" name="officeCode" value="${office.officeCode}" />
            <button type="submit" class="btn btn-danger m1-2">
              <i class="bi bi-trash-fill"></i> Delete
            </button>
          </form>
        </div>
      </div>
    </c:forEach>
  </div>
</div>
<div class="m-3 border-2 p-1 mb-5 bg-body-tertiary rounded">
  <c:if test="${not empty error}">
    <div class="container text-danger border p-3 rounded d-inline-block mx-auto" style="width: fit-content;">
        ${error}
    </div>
  </c:if>
</div>
<div class="m-3 border-2 p-1 mb-5 bg-body-tertiary rounded">
  <c:if test="${empty offices}">
    <div class="container text-danger border p-3 rounded d-inline-block mx-auto" style="width: fit-content;">
      No result
    </div>
  </c:if>
</div>

</body>
</html>
