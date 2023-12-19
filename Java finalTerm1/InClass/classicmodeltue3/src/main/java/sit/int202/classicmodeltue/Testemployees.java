package sit.int202.classicmodeltue;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodeltue.entities.Employees;
import sit.int202.classicmodeltue.entities.Environment;

public class Testemployees {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.PUNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Employees employees = em.find(Employees.class,1002);
        if(employees != null){
            System.out.println(employees);
        }
    }
}
