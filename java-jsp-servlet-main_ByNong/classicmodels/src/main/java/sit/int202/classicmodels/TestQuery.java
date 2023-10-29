package sit.int202.classicmodels;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodels.entites.Employee;
import sit.int202.classicmodels.entites.Office;

import java.util.List;
import java.util.Scanner;

public class TestQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
//        Query query = em.createNamedQuery("OFFICE.FIND_ALL");
        Query query = em.createNamedQuery("OFFICE.FIND_BY_COUNTRY");
        System.out.print("Find office by country start with: ");
        String country = new Scanner(System.in).next();
        query.setParameter("country", country+"%");
        List<Office> offices = query.getResultList();
        for (Office office : offices) {
            System.out.printf("%-2s %-20s %-15s %-12s\n", office.getOfficeCode(),
                    office.getAddressLine1(), office.getCity(), office.getCountry());
        }
        System.out.println("-------------------------------------------------------");
        List<Employee> employees = em.createNamedQuery("EMPLOYEE.FINDALL").getResultList();
        for (Employee emp : employees) {
            System.out.printf("%-4s %-10s %-10s %-22s\n", emp.getId(),
                    emp.getFirstName(), emp.getLastName(), emp.getEmail());
        }
        em.close();
    }
}
