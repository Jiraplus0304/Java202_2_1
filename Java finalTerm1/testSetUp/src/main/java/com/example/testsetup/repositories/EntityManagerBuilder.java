package com.example.testsetup.repositories;

import com.example.testsetup.entities.Environment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerBuilder {
    private  static  final EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.PU_NAME);

public static EntityManager getEntityManager(){
return emf.createEntityManager();
}
}
