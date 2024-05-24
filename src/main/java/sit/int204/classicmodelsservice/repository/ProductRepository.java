package sit.int204.classicmodelsservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sit.int204.classicmodelsservice.entities.Product;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query(value = "SELECT * FROM products where buyPrice > ?1 and  buyPrice < ?2 and productName like %?3%", nativeQuery = true)
    List<Product> findByBuyPriceBetweenAndProductNameContains(Double min, Double max, String str);

    List<Product> findByProductNameContains(String name);

    List<Product> findByProductLineStartsWith(String line);

    List<Product> findByPriceBetweenAndProductNameContains(Double lower, Double upper, String partOfName, Sort sort);
    Page<Product> findByPriceBetweenAndProductNameContains(Double lower, Double upper, String partOfName, Pageable pageable);

    Product findFirstByOrderByPriceDesc();
}
