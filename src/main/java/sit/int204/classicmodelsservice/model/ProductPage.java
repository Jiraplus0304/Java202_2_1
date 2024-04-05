package sit.int204.classicmodelsservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sit.int204.classicmodelsservice.entities.Product;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductPage {
    private List<Product> productList;
    private int pageNumber;
    private int pageSize;
    private long totalElement;
    private int totalPage;


}
