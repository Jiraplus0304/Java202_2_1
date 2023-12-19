package sit.int202.classicmodeltue;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodeltue.entities.Employees;
import sit.int202.classicmodeltue.entities.Environment;
import sit.int202.classicmodeltue.entities.Office;

import java.util.List;

public class TestQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.PUNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("OFFICE.FIND_ALL");
        List<Office> officeList = query.getResultList();
        for(Office office : officeList){
            System.out.printf("%-2s %-20s %-12s %-12s\n",
                office.getOfficeCode(),office.getAddressLine1(),office.getCity(),office.getCountry());
        }
        System.out.println("----------------------------------------");
        Query query2 = em.createNamedQuery("EMPLOYEE.FIND_ALL");
        List<Employees> employeesList = query2.getResultList();
        for(Employees employees : employeesList){
            System.out.printf("%4d %-10s %-12s\n",
                    employees.getEmployeeNumber(),employees.getFirstName(),employees.getLastName());
        }
        em.close();
    }
}
