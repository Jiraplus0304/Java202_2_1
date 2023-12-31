package addremove.kak.addremovekakkak.repositories;

import addremove.kak.addremovekakkak.entities.Environment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerBuilder {
    private final  static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory(Environment.UNIT_NAME);
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
