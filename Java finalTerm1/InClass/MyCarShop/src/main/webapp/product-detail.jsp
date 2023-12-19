<jsp:useBean id="selectedProduct" scope="session" type="com.example.mycarshop.entities.Product"/>
<h1 class="text-[24px]">Info</h1>
<div class=" flex ">
  <div class="w-2/4 flex flex-col ">
    <img class="w-[90%]" src="model-images/${selectedProduct.productLine}/${selectedProduct.productCode}.jpg" alt="car">
  </div>
  <div class="w-2/4 flex flex-col justify-between">
    <div class="flex flex-col w-full justify-between gap-3">
      <p>Code: ${selectedProduct.productCode}</p>
      <p>Name: ${selectedProduct.productName}</p>
      <p>Product Line: ${selectedProduct.productLine}</p>
      <p>Product Vendor: ${selectedProduct.productVendor}</p>
    </div>

    <div class="flex flex-col gap-3 ">
      <div class="flex gap-3 justify-between mt-auto ">
        <p>Price : ${selectedProduct.price}$</p>
        <p>Stock : ${selectedProduct.quantityInStock}</p>
      </div>
      <button class="h-[50px] rounded-lg bg-yellow-500">Add Cart</button>
      <button class="h-[50px] rounded-lg bg-green-700">Buy</button>
    </div>
  </div>
</div>
<p>Detail: <br>
  ${selectedProduct.productDescription}</p>