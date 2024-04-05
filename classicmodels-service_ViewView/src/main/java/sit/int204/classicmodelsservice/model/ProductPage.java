package sit.int204.classicmodelsservice.model;

import lombok.Data;
import sit.int204.classicmodelsservice.Entities.Product;

import java.util.List;

@Data
public class ProductPage {
    private List<Product> productList;
    private int pageNumber;
    private int pageSize;
    private int totalElements;
    private int totalPages;
}
