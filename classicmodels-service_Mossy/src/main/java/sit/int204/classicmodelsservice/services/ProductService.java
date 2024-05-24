package sit.int204.classicmodelsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelsservice.entities.Product;
import sit.int204.classicmodelsservice.repositories.ProductRepositories;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepositories repository;
    public List<Product> findAllProductByProductLine(String prodcutLine){
        return repository.findByProductLineStartingWith(prodcutLine);
    }
    public List<Product> findAllProduct(Double lower,Double upper,String partOfProductName) {
        if (upper < lower) {
            double tmp = upper;
            upper = lower;
            lower = tmp;
        }
        if (upper <= 0 && lower <=0) {
                       return repository.findByProductNameContains(partOfProductName);
        }else {
            return repository.findByPriceBetweenAndProductNameContains(lower, upper, partOfProductName);
//            return repository.findByPriceAndName(lower, upper, "%"+partOfProductName +"%");

        }
    }
    public List<Product> findAllProduct(Double lower,Double upper,String partOfProductName,String[] sortBy,String[] direction) {
        if (upper < lower) {
            double tmp = upper;
            upper = lower;
            lower = tmp;
        }
        if (upper <= 0 && lower <=0) {
            upper = repository.findFirstByOrderByPriceDesc().getPrice();
        }
        List<Sort.Order> sortOrders = new ArrayList<>();
        if(sortBy == null || sortBy.length > 0){
            for (int i = 0; i < sortBy.length; i++) {
                sortOrders.add(new Sort.Order((direction[i].equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC),sortBy[i]));
            }
        }
        return repository.findByPriceBetweenAndProductNameContains(
                lower, upper, partOfProductName, Sort.by(sortOrders));

    }
    //method overload findAllProduct
    //return page product
    public Page<Product> findAllProduct(Double lower, Double upper, String partOfProductName, String[] sortBy, String[] direction, int pageNo, int pageSize) {
        if (upper < lower) {
            double tmp = upper;
            upper = lower;
            lower = tmp;
        }
        if (upper <= 0 && lower <=0) {
            upper = repository.findFirstByOrderByPriceDesc().getPrice();
        }
//        if(sortBy == null || sortBy.isEmpty()) { sortBy = "productCode" ; }
//        Sort.Order sortOrder = new Sort.Order((direction.equalsIgnoreCase("asc")?
//                Sort.Direction.ASC : Sort.Direction.DESC), sortBy);
        List<Sort.Order> sortOrders = new ArrayList<>();
        if(sortBy == null || sortBy.length > 0){
            for (int i = 0; i < sortBy.length; i++) {
                sortOrders.add(new Sort.Order((direction[i].equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC),sortBy[i]));
            }
        }
        if (pageSize <= 0){
            pageSize = (int) repository.count();
        }
        Pageable pageable = PageRequest.of(pageNo,pageSize,Sort.by(sortOrders));
        return repository.findByPriceBetweenAndProductNameContains(lower, upper, partOfProductName, pageable);

    }

    public List<Product> findAllProduct(){
        return repository.findAll();
    }
}
