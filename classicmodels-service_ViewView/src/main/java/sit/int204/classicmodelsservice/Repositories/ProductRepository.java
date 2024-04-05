package sit.int204.classicmodelsservice.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.int204.classicmodelsservice.Entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {
    // Exercise 1
    List<Product> findProductByProductLine(String productLine);
    List<Product> findProductByProductCodeContains(String productCode);

    Product findProductByProductCode(String productCode);

    // =============================
    List<Product> findByPriceBetweenAndProductNameContains(Double lower,Double upper,String partOfName);
    List<Product> findByPriceBetween(Double lower,Double upper);

    List<Product> findByProductNameContains(String name);

    @Query("select p from Product p where p.price >= :lowerPrice and p.price < :upperPrice and p.productName like :name")
    List<Product> findByPriceAndName(Double lowerPrice,Double upperPrice,String name);

    List<Product> findByPriceBetweenAndProductNameContains(Double lower, Double upper, String partOfName, Sort sort);
    Page<Product> findByPriceBetweenAndProductNameContains(Double lower, Double upper, String partOfName, Pageable pageable);


    Product findFirstByOrderByPriceDesc();
}
