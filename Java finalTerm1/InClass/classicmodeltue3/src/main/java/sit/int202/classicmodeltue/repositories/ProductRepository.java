package sit.int202.classicmodeltue.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.classicmodeltue.entities.Product;

import java.util.List;

import static sit.int202.classicmodeltue.repositories.EntityManagerBuilder.getEntityManager;

public class ProductRepository {
    private static int PAGE_SIZE = 10;
    private EntityManager entityManager;


    public int getDefaultPageSize() {
        return PAGE_SIZE;
    }

    private EntityManager getEntityManager(){
        if (entityManager == null || !entityManager.isOpen()){
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Product> findAll(int page, int pageSize) {
        int startPosition = (page-1) * pageSize;
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("PRODUCT.FIND_ALL");
        query.setFirstResult(startPosition);
        query.setMaxResults(pageSize);
        List<Product> productList = query.getResultList();
        return productList;
    }

    public int countAll() {
        EntityManager entityManager = getEntityManager();
        int number = ((Number) entityManager.createNamedQuery("PRODUCT.COUNT").getSingleResult()).intValue();
        return number;
    }

    public Product findProduct(String productCode) {
        return getEntityManager().find(Product.class,productCode);
    }
}