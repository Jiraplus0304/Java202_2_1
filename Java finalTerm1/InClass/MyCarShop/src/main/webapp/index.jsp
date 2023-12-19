<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html class="overflow-y-hidden overflow-x-hidden  overscroll-y-none">

<head>
    <title>Login Page</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-black">
<div class="bg-black w-screen min-h-screen  flex flex-col items-center justify-center ">
    <h1 class="text-white text-[50px]">Welcome to Vehicle Shop</h1>
    <div class="h-max my-[100px] w-max bg-[#2F4241] flex flex-col items-center rounded-lg p-[30px]">
        <h1 class="text-white text-[30px] ">Login</h1>
        <form action="homePage" method="post" class="flex flex-col gap-5 m-10">
            <input class="w-[500px] h-[50px] rounded-md p-3" type="text" name="username" placeholder="Username" />
            <input class="w-[500px] h-[50px] rounded-md  p-3" type="password" name="password" placeholder="Password" />
            <input class="w-[500px] h-[50px] rounded-md bg-yellow-300 mt-10" type="submit" value="Login">
        </form>

    </div>

</div>
<br />
</body>

</html>