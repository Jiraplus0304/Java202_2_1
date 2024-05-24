package sit.int204.classicmodelsservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelsservice.Entities.Customera;
import sit.int204.classicmodelsservice.Entities.Product;
import sit.int204.classicmodelsservice.Repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    // Excercise 1
    public List<Product> findProductByProductLine(String productLine) {
        return repository.findProductByProductLine(productLine);
    }

    public List<Product> findProductByProductCodeContains(String productCode) {
        return repository.findProductByProductCodeContains(productCode);
    }

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(Product updateProduct, String id) {
        Product product = repository.findProductByProductCode(id);
        if(product != null) {
        product.setProductCode(id);
        product.setProductName(updateProduct.getProductName() != null ? updateProduct.getProductName() : product.getProductName());
        product.setProductLine(updateProduct.getProductLine() != null ? updateProduct.getProductLine() : product.getProductLine());
        product.setProductScale(updateProduct.getProductScale() != null ? updateProduct.getProductScale() : product.getProductScale());
        product.setProductVendor(updateProduct.getProductVendor() != null ? updateProduct.getProductVendor() : product.getProductVendor());
        product.setProductDescription(updateProduct.getProductDescription() != null ? updateProduct.getProductDescription() : product.getProductDescription());
        product.setQuantityInStock(updateProduct.getQuantityInStock() != null ? updateProduct.getQuantityInStock() : product.getQuantityInStock());
        product.setBuyPrice(updateProduct.getBuyPrice() != null ? updateProduct.getBuyPrice() : product.getBuyPrice());
        product.setPrice(updateProduct.getPrice() != null ? updateProduct.getPrice() : product.getPrice());
        repository.save(product);
        }

        return null;
    }

    public List<Product> findAllProducts(Double lower, Double upper, String partOfProductName, String[] sortBy, String[] direction) {
        if (upper < lower) {
            double tmp = upper;
            upper = lower;
            lower = tmp;
        }
        if (upper <= 0 && lower <= 0) {
            upper = repository.findFirstByOrderByPriceDesc().getPrice();
        }
        List<Sort.Order> sortOrder = new ArrayList<>();
        if (sortBy != null && sortBy.length > 0) {
            for (int i = 0; i < sortBy.length; i++) {
                sortOrder.add(new Sort.Order((direction[i].equalsIgnoreCase("asc") ?
                        Sort.Direction.ASC : Sort.Direction.DESC), sortBy[i]));
            }
        }
        return repository.findByPriceBetweenAndProductNameContains(lower, upper, partOfProductName, Sort.by(sortOrder));
    }

    public Page<Product> findAllProducts(Double lower, Double upper, String partOfProductName,
                                         String[] sortBy, String[] direction, int pageNo, int pageSize) {
        if (upper < lower) {
            double tmp = upper;
            upper = lower;
            lower = tmp;
        }
        if (upper <= 0 && lower <= 0) {
            upper = repository.findFirstByOrderByPriceDesc().getPrice();
        }
        List<Sort.Order> sortOrder = new ArrayList<>();
        if (sortBy != null && sortBy.length > 0) {
            for (int i = 0; i < sortBy.length; i++) {
                sortOrder.add(new Sort.Order((direction[i].equalsIgnoreCase("asc") ?
                        Sort.Direction.ASC : Sort.Direction.DESC), sortBy[i]));
            }
        }
        if (pageSize <= 0) {
            pageSize = (int) repository.count();
        }
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortOrder));
        return repository.findByPriceBetweenAndProductNameContains(lower, upper, partOfProductName, pageable);
    }

    public List<Product> findAllProducts() {
        return repository.findAll();
    }

}
