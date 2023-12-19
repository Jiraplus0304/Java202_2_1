package sit.int202.classicmodelfri.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.classicmodelfri.entities.Customer;

import java.util.List;

public class CustomerRepository {
    private EntityManager entityManager;
    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public Customer findByName(String name){
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("CUSTOMER.FIND_USER");
        query.setParameter("user_account",name);
        return (Customer) query.getSingleResult();
    }

    public List<Customer> findAll(){
        return getEntityManager().createQuery("SELECT c FROM Customer c").getResultList();
    }
}
