package addremove.kak.addremovekakkak.repositories;

import addremove.kak.addremovekakkak.entities.Customer;
import addremove.kak.addremovekakkak.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;


import java.util.List;

public class CustomerRepository {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }
    public boolean delete(Customer customer) {
        if (customer != null) {
            EntityManager entityManager = getEntityManager();
            if (entityManager.contains(customer)) {
                entityManager.getTransaction().begin();
                entityManager.remove(customer);
                entityManager.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean insert(Customer newCustomer) {
        if (newCustomer != null) {
            EntityManager entityManager = getEntityManager();
            Customer existingCustomer = findByID(newCustomer.getCustomerNumber());
            if (existingCustomer == null) {
                entityManager.getTransaction().begin();
                entityManager.persist(newCustomer);
                entityManager.getTransaction().commit();
                return true;
            }
        }
        return false;
    }


    public Customer findByName(String name) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("FIND_USER");
        query.setParameter("user_account", name);
        return (Customer) query.getSingleResult();
    }

    public Customer findByID(String id) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("FIND_CUS");
        query.setParameter("id", id);
        try {
            return (Customer) query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }

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