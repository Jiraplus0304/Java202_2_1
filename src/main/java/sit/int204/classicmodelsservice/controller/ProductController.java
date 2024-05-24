package sit.int204.classicmodelsservice.controller;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.entities.Product;
import sit.int204.classicmodelsservice.model.ProductPage;
import sit.int204.classicmodelsservice.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;


    @GetMapping("/product-line/{id}")
    public List<Product> findAllProducts(@PathVariable String id) {
        return service.findAllProductByProductLine(id);
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllProducts(@RequestParam(defaultValue = "")@Size(min = 5) String partOfProductName,
                                                 @RequestParam(defaultValue = "0") Double lower,
                                                 @RequestParam(defaultValue = "0") Double upper,
                                                 @RequestParam(defaultValue = "") String[] sortBy,
                                                 @RequestParam(defaultValue = "ASC") String[] sortDirection,
                                                 @RequestParam(defaultValue = "0") int pageNo,
                                                 @RequestParam(defaultValue = "10")@Min(10) int pageSize) {
        if (pageSize == 0) {
            return ResponseEntity.ok(service.getAllProducts());
        }

        Page<Product> page = service.getAllProducts(lower, upper, partOfProductName, sortBy, sortDirection, pageNo, pageSize);
        ProductPage productPage = new ProductPage();
        productPage.setProductList(page.getContent());
        productPage.setPageSize(page.getNumber());
        productPage.setPageSize(page.getSize());
        productPage.setPageSize(page.getTotalPages());
        productPage.setTotalElement(page.getTotalElements());
        return ResponseEntity.ok(productPage);

    }


}
