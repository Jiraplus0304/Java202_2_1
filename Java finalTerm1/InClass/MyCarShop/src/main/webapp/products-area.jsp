<jsp:useBean id="products" scope="session" class="java.util.ArrayList" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="product"  items="${products}">
  <div onclick="loadProductDetail('${product.productCode}')" class="product  ${selectedProduct.productCode.equals(product.productCode) ? "bg-blue-400" : "bg-slate-700"} justify-between flex rounded-lg p-3 text-[12px]">
    <div class="flex gap-5">
      <img class="h-[76px] " src="model-images/${product.productLine}/${product.productCode}.jpg" alt="${product.productCode}">
      <p>${product.productName}</p>
    </div>
    <div class="flex flex-col justify-between items-end">
      <p>Stock: ${product.quantityInStock}</p>
      <p>Price: ${product.price}$</p>
    </div>
  </div>
</c:forEach>