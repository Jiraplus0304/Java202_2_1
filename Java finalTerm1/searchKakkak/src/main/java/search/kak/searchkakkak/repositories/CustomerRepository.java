package search.kak.searchkakkak.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import search.kak.searchkakkak.entities.Customer;

import java.util.List;

public class CustomerRepository {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public Customer findByName(String name) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("FIND_USER");
        query.setParameter("user_account", name);
        return (Customer) query.getSingleResult();
    }

    public List<Customer> searchByName(String name) {
        Query query = getEntityManager().createNamedQuery("SEARCH");
        query.setParameter("keyword", name);
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }


    public List<Customer> findAll() {
        return getEntityManager().createQuery("select c from Customer c").getResultList();
    }
}