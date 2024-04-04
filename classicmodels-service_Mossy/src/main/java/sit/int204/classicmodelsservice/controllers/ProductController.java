package sit.int204.classicmodelsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.entities.Product;
import sit.int204.classicmodelsservice.models.ProductPage;
import sit.int204.classicmodelsservice.repositories.ProductRepositories;
import sit.int204.classicmodelsservice.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService service;
    @GetMapping("")
    public ResponseEntity<Object> findAllProducts(
            @RequestParam(defaultValue = "") String productName,
            @RequestParam(defaultValue = "0") Double lower,
            @RequestParam(defaultValue = "0") Double upper,
            @RequestParam(defaultValue = "") String[] sortBy,
            @RequestParam(defaultValue = "ASC") String[] sortDirection,
            @RequestParam(defaultValue = "0") int pageNO,
            @RequestParam(defaultValue = "0") int pageSize
    ) {
        if (pageSize == 0) {
            return ResponseEntity.ok(service.findAllProduct());
        } else{
            Page<Product> page = service.findAllProduct(lower, upper, productName, sortBy, sortDirection, pageNO, pageSize);
            ProductPage pageProduct = new ProductPage();
            pageProduct.setProductList(page.getContent());
            pageProduct.setPageNumber(page.getNumber());
            pageProduct.setPageSize(page.getSize());
            pageProduct.setTotalPage(page.getTotalPages());
            pageProduct.setTotalElement((int)page.getTotalElements());
            return ResponseEntity.ok(pageProduct);
        }
    }

    @GetMapping("/product-line/{id}")
    public List<Product> findAllProducts(@PathVariable String id){
        return service.findAllProductByProductLine(id);
    }
}
