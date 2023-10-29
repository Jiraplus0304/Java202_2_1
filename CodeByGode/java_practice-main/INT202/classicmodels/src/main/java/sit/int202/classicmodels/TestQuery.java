package sit.int202.classicmodels;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodels.entities.Employee;
import sit.int202.classicmodels.entities.Office;

import java.util.List;
import java.util.Scanner;

public class TestQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
//        Query query = em.createNamedQuery("OFFICE.FIND_ALL");
        Query query = em.createNamedQuery("OFFICE.FIND_BY_COUNTRY");
        String country =new Scanner(System.in).next();
        query.setParameter("country",country);

        List<Office> offices = query.getResultList();
        for (Office o: offices) {
//            System.out.println(o);
            System.out.printf("(%2s) %-25s %-15s %-12s\n" ,o.getOfficeCode() , o.getCity() ,o.getAddressLine1() ,o.getPostalCode());
        }
        System.out.println("---------------------------------------");
        List<Employee> employees = em.createNamedQuery("EMPLOYEE.FIND_ALL").getResultList();
        for (Employee emp: employees) {
            //System.out.println(emp);
            System.out.printf("%d %-15s %-35s %s\n" ,emp.getId() ,emp.getFirstName(), emp.getEmail(), emp.getJobTitle());
        }
        em.close();
    }
}
