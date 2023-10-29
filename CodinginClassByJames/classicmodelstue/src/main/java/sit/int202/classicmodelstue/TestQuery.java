package sit.int202.classicmodelstue;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodelstue.entities.Employee;
import sit.int202.classicmodelstue.entities.Office;

import java.util.List;

public class TestQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("OFFICE.FIND_ALL");
        List<Office> officeList = query.getResultList();
        Query query2 = em.createNamedQuery("EMPLOYEE.FIND_ALL");
        List<Employee> employeeList = query2.getResultList();
        for (Office office : officeList) {
            System.out.printf("%-2s %-25s %-13s %-12s\n",
                    office.getOfficeCode(), office.getAddressLine1(),
                    office.getCity(), office.getCountry());
        }
        System.out.println("---------------------------------------------");
        for (Employee employee : employeeList) {
            System.out.printf("%-5s %-10s %-13s %-12s\n",
                    employee.getEmployeeNumber(), employee.getFirstName(),
                    employee.getLastName(), employee.getJobTitle());
        }
        em.close();
    }
}