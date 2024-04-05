package sit.int204.classicmodelsservice.Controller;

import jakarta.validation.constraints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.Entities.Product;
import sit.int204.classicmodelsservice.Service.ProductService;
import sit.int204.classicmodelsservice.model.ProductPage;

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
            @RequestParam(defaultValue = "0") @Min(0) int pageNo,
            @RequestParam(defaultValue = "0") @Min(10) int pageSize) {
        System.out.println("HELLO WORLD");
        if (pageSize == 0) {
            return ResponseEntity.ok(service.findAllProducts());
        } else {
            Page<Product> page = service.findAllProducts(lower, upper, productName, sortBy, sortDirection, pageNo, pageSize);
            System.out.println(page.toString());
            System.out.println(page);
            ProductPage pp = new ProductPage();
            pp.setProductList(page.getContent());
            pp.setPageNumber(page.getNumber());
            pp.setPageSize(page.getSize());
            pp.setTotalPages(page.getTotalPages());
            pp.setTotalElements((int) page.getTotalElements());
            return ResponseEntity.ok(pp);
        }
    }
    // Exercise 1
    @GetMapping("/product-line/{id}")
    public List<Product> getProductByProductLine(@PathVariable(required = false) String id){
        if(id == null) id = "Motorcycles";
        return service.findProductByProductLine(id);
    }
    @GetMapping("/{id}")
    public List<Product> getProductByProductCode(@PathVariable String id){
        return service.findProductByProductCodeContains(id);
    }
    @PostMapping("/{id}")
    public Product createNewProduct(@RequestBody Product product,@PathVariable Double id){
        product.setBuyPrice(id);
        return service.createProduct(product);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody(required = false) Product product,@PathVariable String id ){
        System.out.println(id);
        return service.updateProduct(product,id);

    }
}
