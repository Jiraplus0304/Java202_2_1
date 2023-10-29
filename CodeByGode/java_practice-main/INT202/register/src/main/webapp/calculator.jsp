<%--
  Created by IntelliJ IDEA.
  User: sorra
  Date: 8/10/2566
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculator</title>
    <link rel="stylesheet" href="css/calculator_style.css">
</head>

<body>
<div class="wrapper">
    <h3>Calculator</h3>
    <section class="screen">
        <div class="previous" data-operand-previous></div>
        <div class="current" data-operand-current></div>
    </section>
    <section class="calc-btn-row">
        <div class="calc_btn_row">
            <button class="calc_btn double" data-all-clear>C</button>
            <button class="calc_btn" data-delete>←</button>
            <button class="calc_btn" data-operation>÷</button>
        </div>
        <div class="calc_btn_row">
            <button class="calc_btn" data-number>7</button>
            <button class="calc_btn" data-number>8</button>
            <button class="calc_btn" data-number>9</button>
            <button class="calc_btn" data-operation>x</button>
        </div>
        <div class="calc_btn_row">
            <button class="calc_btn" data-number>4</button>
            <button class="calc_btn" data-number>5</button>
            <button class="calc_btn" data-number>6</button>
            <button class="calc_btn" data-operation>-</button>
        </div>
        <div class="calc_btn_row">
            <button class="calc_btn" data-number>1</button>
            <button class="calc_btn" data-number>2</button>
            <button class="calc_btn" data-number>3</button>
            <button class="calc_btn" data-operation>+</button>
        </div>
        <div class="calc_btn_row">
            <button class="calc_btn double" data-number>0</button>
            <button class="calc_btn" data-number>.</button>
            <button class="calc_btn" data-equals>=</button>
        </div>
    </section>
</div>
<script src="js/calculator_script.js"></script>
</body>

</html>
