package int202.testweblogin.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import int202.testweblogin.entities.Product;

import java.util.List;

public class ProductRepository {
    private EntityManager entityManager;
    private final static int PAGE_SIZE = 10;

    private EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public int getDefaultPageSize() {
        return PAGE_SIZE;
    }

    public Product findProduct(String productCode) {
        return getEntityManager().find(Product.class, productCode);
    }

    public List<Product> findAll(int page, int pageSize) {
        int startPosition = (page - 1) * pageSize;
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

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
