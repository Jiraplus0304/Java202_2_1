package sit.int204.classicmodelsservice.controllers;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import sit.int204.classicmodelsservice.entities.Product;
import sit.int204.classicmodelsservice.exception.ErrorResponse;
import sit.int204.classicmodelsservice.exception.ItemNotFoundException;
import sit.int204.classicmodelsservice.models.ProductPage;
import sit.int204.classicmodelsservice.repositories.ProductRepository;
import sit.int204.classicmodelsservice.services.ListMapper;
import sit.int204.classicmodelsservice.services.ProductService;

import java.util.List;

import static sit.int204.classicmodelsservice.services.ListMapper.listMapper;

@RestController
@RequestMapping("/products")
public class ProductController {

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ItemNotFoundException handleItemNotFound(
            ItemNotFoundException exception) {
        return exception;
    }

    @Autowired
    ProductService service;
    @Autowired
    ListMapper listMapper;

    @GetMapping("/queryByExample")
    public ResponseEntity<Object> findByExample(){
        return ResponseEntity.ok(service.getProductByExample());
    }

    @GetMapping("")
    public ResponseEntity<Object> findAllProducts(
            @RequestParam(defaultValue = "") @Size(min=5) String productName,
            @RequestParam(defaultValue = "0") Double lower,
            @RequestParam(defaultValue = "0") Double upper,
            @RequestParam(defaultValue = "") String[] sortBy,
            @RequestParam(defaultValue = "ASC") String[] sortDirection,
            @RequestParam(defaultValue = "0") @Min(0) int pageNo,
            @RequestParam(defaultValue = "10") @Min(10) @Max(20) int pageSize) {
        Page<Product> page = service.findAllProducts(lower, upper, productName, sortBy, sortDirection, pageNo, pageSize);
        return ResponseEntity.ok(listMapper.toPage);
    }

    @GetMapping("/product-line/{id}")
    public List<Product> findAllProducts(@PathVariable String id) {
        return service.findAllProductsByProductLine(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProuctById(@PathVariable String id) {
        return ResponseEntity.ok(service.getProductById(id));
    }
//
//    @ExceptionHandler(ItemNotFoundException.class)
//    @ResponseStatus(code = HttpStatus.
//            NOT_FOUND)
//    public ResponseEntity<ErrorResponse> handleItemNotFound(ItemNotFoundException ex, WebRequest request) {
//        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(),
//                request.getDescription(false));
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
//    }
}

