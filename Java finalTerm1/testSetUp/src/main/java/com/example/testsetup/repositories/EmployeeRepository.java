package com.example.testsetup.repositories;

import com.example.testsetup.entities.Employee;
import jakarta.persistence.EntityManager;

import java.util.List;


public class EmployeeRepository {
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Employee> findAll(){
        return  getEntityManager().createNamedQuery("EMPLOYEE_FIND_ALL").getResultList();
    }


}
