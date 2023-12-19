<jsp:useBean id="curCustomer" scope="session" type="com.example.mycarshop.entities.Customer"/>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html class="overflow-y-hidden overflow-x-hidden  overscroll-y-none">

<head>
    <title>Home Page</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script defer src="./script/script.js"></script>
</head>

<body class="bg-black text-white flex flex-col gap-10">
<nav id="nav" class="h-[75px] text-[20px] w-screen bg-slate-700 flex items-center px-5  justify-between">
    <a>Car Shop</a>
    <div class="flex gap-5">
        <a id="product-list">ProductList</a>
        <a id="cart">Cart</a>
        <a id="history">History</a>
        <a id="add-cash">Cash : ${curCustomer.creditLimit}$</a>
    </div>
</nav>

<div id="display" class="w-screen h-screen  flex flex-col items-center gap-10 ">
    <h1 class="text-[50px]">Welcome, ${curCustomer.customerName}</h1>
    <div class="h-max w-[90%]  bg-slate-700  flex flex-col  rounded-lg p-[30px]">
        <div id="info" class="h-[60vh] p-10 flex">
            <div class="flex h-full flex-col gap-8 text-[45px] w-[50%]">
                <p>ID: ${curCustomer.customerNumber}</p>
                <p>Name: ${curCustomer.customerName}</p>
                <p>Phone: ${curCustomer.phone}</p>
                <p>Address: <br>
                    ${curCustomer.addressLine1} ${curCustomer.addressLine2}</p>
            </div>
            <div class="flex h-full bg-slate-500 rounded-lg flex-col gap-8 text-[20px] w-[50%] justify-center items-center">
                Map
            </div>
        </div>
    </div>
</div>
<br />
</body>

</html>