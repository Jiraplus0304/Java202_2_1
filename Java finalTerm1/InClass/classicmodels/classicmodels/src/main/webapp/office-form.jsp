<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update & Insert</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.1/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body class="container mt-3 justify-content-center align-items-center">
<div class="row bg-info text-white rounded">
    <h2>Add & Update here!!!</h2>
</div>
<div class="justify-content center mt-3">
    <div class="col-md-12">
        <form action="office-action" method="post" class="bg-light p-4 rounded shadow">
            <input type="hidden" name="action" value="${requestScope.action == 'add' ? 'add' : 'update'}" />

            <div class="row">
                <div class="col-md-4">
                    <div class="mb-3">
                        <label for="officeCode" class="form-label" >officeCode</label>
                        <input type="text" id="officeCode" class="form-control" ${requestScope.action == 'add' ? '' : 'readonly'} name="officeCode" value="${requestScope.office.officeCode}">
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="mb-3">
                        <label for="city" class="form-label">city</label>
                        <input type="text" id="city" name="city" class="form-control" value="${requestScope.office.city}">
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="mb-3">
                        <label for="phone" class="form-label">phone</label>
                        <input type="text" id="phone" name="phone" class="form-control" value="${requestScope.office.phone}">
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="mb-3">
                        <label for="add1" class="form-label">addressLine1</label>
                        <input type="text" id="add1" name="addressLine1" class="form-control" value="${requestScope.office.addressLine1}">
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="mb-3">
                        <label for="add2" class="form-label">addressLine2</label>
                        <input type="text" id="add2" name="addressLine2" class="form-control" value="${requestScope.office.addressLine2}">
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="mb-3">
                        <label for="state" class="form-label">state</label>
                        <input type="text" id="state" name="state" class="form-control" value="${requestScope.office.state}">
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="mb-3">
                        <label for="country" class="form-label">country</label>
                        <input type="text" id="country" name="country" class="form-control" value="${requestScope.office.country}">
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="mb-3">
                        <label for="postCode" class="form-label">postalCode</label>
                        <input type="text" id="postCode" name="postalCode" class="form-control" value="${requestScope.office.postalCode}">
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="mb-3">
                        <label for="ter" class="form-label" >territory</label>
                        <input type="text" id="ter" name="territory" class="form-control" value="${requestScope.office.territory}">
                    </div>
                </div>
            </div>

            <div class="">
                <button type="submit" class="btn btn-primary">
                    ${requestScope.action == 'add' ? 'Add' : 'Update'}
                </button>
                <a href="office-list" class="btn btn-secondary" >
                    <i class="bi bi-arrow-left"></i> Go Back
                </a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
