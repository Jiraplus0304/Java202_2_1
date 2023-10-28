package sit.int202.classicmodelstue;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodelstue.entities.Employee;
import sit.int202.classicmodelstue.entities.Office;

import java.util.List;
import java.util.Scanner;

public class TestPagination {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("EMPLOYEE.FIND_ALL");
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter no of entity per page: ");
        int pageSize = sc.nextInt();
        int beginFrom =0;
        query.setMaxResults(pageSize);
        while (true){
            query.setFirstResult(beginFrom);
            List<Employee> employeeList=query.getResultList();
            if(employeeList.isEmpty()){
                break;
            }
            displayEmployees(employeeList);
            System.out.println("---------------------------------------------");
            System.out.print("Press any key the enter to see next page ....");
            sc.next();
            beginFrom = beginFrom + pageSize;
        }
        em.close();
    }

    private static void displayEmployees(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            System.out.printf("%-5s %-10s %-13s %-12s\n",
                    employee.getEmployeeNumber(), employee.getFirstName(),
                    employee.getLastName(), employee.getJobTitle());
        }
    }
}
