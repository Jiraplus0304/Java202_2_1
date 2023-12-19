package login.kakkak.loginkakak.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import login.kakkak.loginkakak.entities.Customer;

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
        try {
            query.setParameter("user_account", name);
        }catch (NoResultException e){
            System.out.println("Not found name");
        }

        return (Customer) query.getSingleResult();
    }

    public List<Customer> findAll() {
        return getEntityManager().createQuery("select c from Customer c").getResultList();
    }
}