package sit.int202.classicmodeltue;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodeltue.entities.Employees;
import sit.int202.classicmodeltue.entities.Environment;
import sit.int202.classicmodeltue.entities.Office;

import java.util.List;
import java.util.Scanner;

public class TestEntityRelationship {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.PUNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);
        Query query = em.createNamedQuery("OFFICE.FIND_ALL");
        List<Office> officeList = query.getResultList();
        for (Office office : officeList){
            displayEmployees(office);
        }

        do {
            System.out.print("Enter office code (0 to stop): ");
            String officeCode = sc.next();
            if(officeCode.equalsIgnoreCase("0")){
                break;
            }
            Office office = em.find(Office.class,officeCode);
            if (office == null){
                System.out.println("Office code " + officeCode + "does not exist !!");
            } else {
                displayEmployees(office);
            }
        } while (true);
    }
    public static void displayEmployees(Office office){
        System.out.println(office.getOfficeCode() + " " + office.getCity() + ", " +
                office.getCountry());
        System.out.println("----------------------------------------------");
        for(Employees employees : office.getEmployeeList()) {
            System.out.printf("%4d %-10s %-12s\n",
                    employees.getEmployeeNumber(), employees.getFirstName(), employees.getLastName());
        }
        System.out.println();
    }
}
