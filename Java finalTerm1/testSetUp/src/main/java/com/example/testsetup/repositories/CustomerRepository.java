package com.example.testsetup.repositories;

import com.example.testsetup.entities.Customer;
import com.example.testsetup.entities.Employee;
import jakarta.persistence.EntityManager;
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

    public boolean insert(Customer customer) {
        try {
            EntityManager entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public Customer findByName(String name) {
        EntityManager em = getEntityManager();
        Query query = em.createNamedQuery("CUSTOMER.FIND_USER");
        query.setParameter("user_account", name);
        return (Customer) query.getSingleResult();
    }

    public List<Customer> findAll(){
        return  getEntityManager().createNamedQuery("CUSTOMER.FIND_ALL").getResultList();
    }
}
