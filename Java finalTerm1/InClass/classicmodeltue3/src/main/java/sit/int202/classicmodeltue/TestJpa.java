package sit.int202.classicmodeltue;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodeltue.entities.Environment;
import sit.int202.classicmodeltue.entities.Office;

import java.util.Scanner;

public class TestJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.PUNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Office office = em.find(Office.class,"8");
        if(office != null){
            System.out.println(office);
        } else {
            System.out.println("No specify office !!!");
            Office newOffice = new Office();
            newOffice.setOfficeCode("8");
            newOffice.setCountry("Thailand");
            newOffice.setCity("Bangkok");
            newOffice.setAddressLine1("126 xxxxxxx");
            newOffice.setPhone("0897869879");
            newOffice.setPostalCode("10150");
            newOffice.setTerritory("xx");
            em.getTransaction().begin();
            em.persist(newOffice);
            em.getTransaction().commit();
            System.out.println(newOffice);
        }
        System.out.println("Enter office code you want to delete: ");
        String x = new Scanner(System.in).next();
        Office delOffice = em.find(Office.class, x);
        if (delOffice != null){
            em.getTransaction().begin();
            em.remove(delOffice);
            em.getTransaction().commit();
        }
        em.close();
        emf.close();
    }
}
