package sit.int202.classicmodels;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodels.entites.Employee;
import sit.int202.classicmodels.entites.Office;

public class TestJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Office office = em.find(Office.class, "7");
        Employee emp = em.find(Employee.class, "1002");
        if (office != null) {
            System.out.printf("%s %s %s\n", office.getCity(), office.getCountry(), office.getPostalCode());
        } else {
            System.out.println("Specify office code does not exist !!!");
        }
        if (!emp.getFirstName().equalsIgnoreCase("somchai")) {
            em.getTransaction().begin();
            emp.setFirstName("Somchai");
            em.persist(emp);
            em.getTransaction().commit();
        }
        System.out.println(emp);
//        Office newOffice = new Office();
//        newOffice.setOfficeCode("8");
//        newOffice.setAddressLine1(office.getAddressLine1());
//        newOffice.setAddressLine2(office.getAddressLine2());
//        newOffice.setCity("Bangmod");
//        newOffice.setCountry("Thailand");
//        newOffice.setPhone(office.getPhone());
//        newOffice.setPostalCode(office.getPostalCode());
//        newOffice.setState(office.getState());
//        newOffice.setTerritory(office.getTerritory());
//        em.getTransaction().begin();
//        em.persist(newOffice);
////        em.remove(office);
//        em.getTransaction().commit();
//        System.out.println("Save newOffice to db");
//        em.close();
    }
}
