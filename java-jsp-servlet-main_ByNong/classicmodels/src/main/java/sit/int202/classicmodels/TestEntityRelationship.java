package sit.int202.classicmodels;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodels.entites.Employee;
import sit.int202.classicmodels.entites.Office;

import java.util.List;

public class TestEntityRelationship {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        List<Office> officeList = em.createNamedQuery("OFFICE.FIND_ALL").getResultList();
        for (Office office : officeList) {
            System.out.printf("(%s) %s %s %s\n", office.getOfficeCode(),
                    office.getAddressLine1(), office.getCity(), office.getCountry());
            System.out.println("----------------------------------------------------");
            for (Employee emp : office.getEmployeeList()) {
                System.out.printf("%12d %-10s %-10s %-22s\n", emp.getId(),
                        emp.getFirstName(), emp.getLastName(), emp.getEmail());
            }
            System.out.println("\n");
        }
        em.close();
    }
}
