<%--
  Created by IntelliJ IDEA.
  User: 9inejames
  Date: 11/11/2023 AD
  Time: 08:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add-New-Office</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
    .form-control {
        border-radius: 30px;
    }

    .btn-danger{
        border-color: olivedrab;
        background-color: white;
        border-width: thin;
        color: olivedrab;
    }
    .btn-danger:hover{
        background-color: olivedrab;
        color: aliceblue;
        border-color: olivedrab;
    }
</style>
<body>
<div class="container">
    <div class="row bg-info pt-2 pb-3">
        <div class="col-8 mt-2">
            <h2>
                <a href="office-list">
                    <button class="btn btn-lg mt-0 pt-0" style="font-size: larger">
                        <i class="fa fa-home"></i>
                    </button>
                </a>
                Add New Office ::
            </h2>
        </div>
        <div class="col-4"></div>
    </div>
    <br>

    <h5 class="text-secondary">Enter your office information</h5><br>

    <form action="add-office" method="post">
        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="offCode" class="ml-2">OFFICE CODE: <span style="color: red">*</span></label>
                <input type="text" name="offCode" class="form-control" id="offCode" placeholder="Your office code" required>
            </div>
            <div class="form-group col-md-4">
                <label for="city" class="ml-2">CITY: <span style="color: red">*</span></label>
                <input type="text" name="city" class="form-control" id="city" placeholder="Your office city" required>
            </div>
            <div class="form-group col-md-4">
                <label for="country" class="ml-2">COUNTRY: <span style="color: red">*</span></label>
                <input type="text" name="country" class="form-control" id="country" placeholder="Your office country" required>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label for="phone" class="ml-2">PHONE: <span style="color: red">*</span></label>
                <input type="text" name="phone" class="form-control" id="phone" placeholder="Your office phone number" required>
            </div>
            <div class="form-group col-md-4">
                <label for="state" class="ml-2">STATE: </label>
                <input type="text" name="state" class="form-control" id="state" placeholder="Your office state">
            </div>
            <div class="form-group col-md-4">
                <label for="territory" class="ml-2">TERRITORY: <span style="color: red">*</span></label>
                <input type="text" name="territory" class="form-control" id="territory"
                       placeholder="Your office territory" required>
            </div>
        </div>

        <div class="form-row mb-2">
            <div class="from-group col-md-6">
                <label for="address1" class="ml-2">ADDRESS LINE1 <span style="color: red">*</span></label>
                <textarea class="form-control" name="address1" id="address1" rows="5"
                          placeholder="Your office address line1" required></textarea>
                <%--                <input type="text" class="form-control" id="address1" placeholder="Your office address line1">--%>
            </div>
            <div class="from-group col-md-6">
                <label for="address2" class="ml-2">ADDRESS LINE2 </label>
                <textarea class="form-control" name="address2" id="address2" rows="5"
                          placeholder="Your office address line2(floor, level etc.)"></textarea>
                <%--                <input type="text" class="form-control" id="address2" placeholder="Your office address line2">--%>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="postalCode" class="ml-2">POSTAL CODE: <span style="color: red">*</span></label>
                <input type="text" name="postalCode" class="form-control" id="postalCode"
                       placeholder="Your office postal code" required>
            </div>
            <div class="col-3"></div>
            <div class="col-3 d-flex p-3 align-items-end justify-content-end">
                <button type="submit" class="btn btn-danger ">ADD OFFICE</button>
            </div>
        </div>

    </form>

</div>
</body>
</html>
