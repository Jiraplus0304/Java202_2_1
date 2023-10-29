package sit.int202.classicmodels;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodels.entities.Employee;
import sit.int202.classicmodels.entities.Office;

public class TestJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        System.out.println(emf);
        EntityManager em = emf.createEntityManager();
        Office office = em.find(Office.class, "5");
        Employee employees = em.find(Employee.class,1002);
        if(!employees.getFirstName().equalsIgnoreCase("somchai")){
            em.getTransaction().begin();
            employees.setFirstName("Somchai");
            em.persist(employees);
            em.getTransaction().commit();
        }
        System.out.println(employees);

//        if(office != null) {
//            System.out.printf("%s %s %s\n", office.getCity() ,office.getCountry() , office.getPostalCode());
//        } else {
//            System.out.println("Office not found");
//        }
//        Office newOffice = new Office();
//        newOffice.setOfficeCode("8");
//        newOffice.setAddressLine1(office.getAddressLine1());
//        newOffice.setAddressLine2(office.getAddressLine2());
//        newOffice.setCity("Bangmod");
//        newOffice.setCountry("Thailand");
//        newOffice.setPhone(office.getPhone());
//        newOffice.setPostalCode(office.getPostalCode());
//        newOffice.setTerritory(office.getTerritory());
//        newOffice.setState(office.getState());
//        newOffice.setTerritory(office.getTerritory());
//        em.getTransaction().begin();
//        em.persist(newOffice);
//        em.getTransaction().commit();
//        em.close();
    }
}
