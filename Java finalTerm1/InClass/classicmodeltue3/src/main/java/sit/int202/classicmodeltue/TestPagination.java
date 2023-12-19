package sit.int202.classicmodeltue;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodeltue.entities.Employees;
import sit.int202.classicmodeltue.entities.Environment;

import java.util.List;

import java.util.Scanner;

public class TestPagination {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.PUNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("EMPLOYEE.FIND_ALL");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of entity per page: ");
        int pageSize = sc.nextInt();
        int beginFrom = 0;
        query.setMaxResults(pageSize);
        while(true){
            query.setFirstResult(beginFrom);
            List<Employees> employeesList = query.getResultList();
            if (employeesList.isEmpty()){
                break;
            }
            displayEmployees(employeesList);
            System.out.println("----------------------");
            System.out.println("Press any key the enter to see next page ...");
            sc.next();
            beginFrom = beginFrom + pageSize;
        }
        em.close();
    }
    public static void displayEmployees(List<Employees> employeesList){
        for(Employees employees : employeesList) {
            System.out.printf("%4d %-10s %-12s\n",
                    employees.getEmployeeNumber(), employees.getFirstName(), employees.getLastName());
        }
    }
}
