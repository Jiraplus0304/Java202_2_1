
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="text-[50px]">Product List</h1>
<div class="h-max w-[90%]  flex justify-between p-[30px] pb-0">
    <div class="rounded-lg bg-slate-600 w-[39%] h-[60vh]  p-5  flex flex-col justify-between ">
        <div id="products-area" class="flex flex-col gap-3 overflow-y-scroll h-full pr-5">
        </div>
        <div class="changPage  flex justify-between items-center px-5 my-5">
            <p>last</p>
            <p>number</p>
            <p>next</p>
        </div>
    </div>
    <div id="product-detail" class="rounded-lg bg-slate-600 w-[59%] h-[60vh] p-10 flex flex-col gap-5">
    </div>
</div>