package sit.int204.classicmodelsservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.int204.classicmodelsservice.entities.Product;

import java.util.List;

public interface ProductRepositories extends JpaRepository<Product,Integer> {
    List<Product> findByPriceBetweenAndProductNameContains(Double lower , Double upper ,String partOfName);
    List<Product> findByPriceBetween(Double lower,Double upper);
    List<Product> findByProductNameContains(String partOfName);
    List<Product> findByProductLineStartingWith(String line);
    @Query("select p from Product p where p.price >= :lowerPrice and p.price < :upperPrice and p.productName like :name ")
    List<Product> findByPriceAndName(Double lowerPrice,Double upperPrice,String name);
    List<Product> findByPriceBetweenAndProductNameContains(
            Double lower, Double upper, String partOfName, Sort sort);
    Product findFirstByOrderByPriceDesc();
    // do method overload
    //must return as page
    Page<Product> findByPriceBetweenAndProductNameContains(
            Double lower, Double upper, String partOfName, Pageable pageable);
}
