package addremove.kak.addremovekakkak.repositories;

import addremove.kak.addremovekakkak.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


import java.util.List;

public class ProductRepository {

    private static int PAGE_SIZE = 10;
    private EntityManager entityManager;

    public int getDefaultPageSize() {
        return PAGE_SIZE;
    }

    private EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;

    }
    public Product findProduct(String productCode) {
        return getEntityManager().find(Product.class, productCode);
    }

    public List<Product> findAll(int page, int pageSize) {
        int startPosition = (page - 1) * pageSize;
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNamedQuery("PRODUCT.FindAll");
        query.setFirstResult(startPosition);
        query.setMaxResults(pageSize);
        List<Product> productList = query.getResultList();
        entityManager.close();
        return productList;
    }

    public int countAll() {
        EntityManager entityManager = getEntityManager();
        int number = ((Number) entityManager.createNamedQuery("PRODUCT.count").getSingleResult()).intValue();
        entityManager.close();
        return number;
    }
}
