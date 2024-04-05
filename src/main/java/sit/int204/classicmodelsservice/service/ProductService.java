package sit.int204.classicmodelsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelsservice.entities.Office;
import sit.int204.classicmodelsservice.entities.Product;
import sit.int204.classicmodelsservice.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProduct(Double min, Double max, String str) {
        if (max < min) {
            Double temp = max;
            max = min;
            min = temp;
        }
        if (min + max > 0) {
            return repository.findByBuyPriceBetweenAndProductNameContains(min, max, str);
        } else {
            return repository.findByProductNameContains(str);
        }
    }

    public List<Product> findAllProductByProductLine(String line) {
        return repository.findByProductLineStartsWith(line);
    }

    public List<Product> getAllProducts(Double lower, Double upper, String partOfName, String[] sortBy, String[] direction) {
        if (upper < lower) {
            Double temp = upper;
            upper = lower;
            lower = temp;
        }
        if (upper <= 0 && lower <= 0) {
            upper = repository.findFirstByOrderByPriceDesc().getPrice();

        }
        List<Sort.Order> orders = new ArrayList<>();
        if (sortBy != null && sortBy.length > 0) {
            for (int i = 0; i < sortBy.length; i++) {
                orders.add(new Sort.Order((direction[i].equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC), sortBy[i]));
            }
        }
        return repository.findByPriceBetweenAndProductNameContains(
                lower, upper, partOfName, Sort.by(orders));
    }

    public Page<Product> getAllProducts(Double lower, Double upper, String partOfName, String[] sortBy, String[] direction, int pageNum , int pageSize ) {
        if (upper < lower) {
            Double temp = upper;
            upper = lower;
            lower = temp;
        }
        if (upper <= 0 && lower <= 0) {
            upper = repository.findFirstByOrderByPriceDesc().getPrice();

        }
        if(pageSize == 0){
            // count row of entity
            pageSize = (int)repository.count();
        }
        List<Sort.Order> orders = new ArrayList<>();
        if (sortBy != null && sortBy.length > 0) {
            for (int i = 0; i < sortBy.length; i++) {
                orders.add(new Sort.Order((direction[i].equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC), sortBy[i]));
            }
        }
        Pageable pageable = PageRequest.of(pageNum,pageSize,Sort.by(orders));
        return repository.findByPriceBetweenAndProductNameContains(
                lower, upper, partOfName, pageable);
    }
    public List<Product> getAllProducts() {
        return  repository.findAll();
    }

}
