package sit.int202.classicmodelstue;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classicmodelstue.entities.Employee;

import java.util.Scanner;

public class TestEmp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        System.out.print("Enter employee number: ");
        String empNum = new Scanner(System.in).next();
        Employee employee = em.find(Employee.class, empNum);
        if(employee != null){
            System.out.println(employee);
        } else {
            System.out.println("no");
            Employee newEmp = new Employee();
//            System.out.print("Enter employee number: ");
//            String empNums = new Scanner(System.in).next();
//            System.out.print("Enter employee first name: ");
//            String empFname = new Scanner(System.in).next();
//            System.out.print("Enter employee last name: ");
//            String empLname = new Scanner(System.in).next();
//            System.out.print("Enter employee email: ");
//            String empEmail = new Scanner(System.in).next();
//            System.out.print("Enter employee office code: ");
//            String offCode = new Scanner(System.in).next();
//            System.out.print("Enter employee Header: ");
//            String repTo = new Scanner(System.in).next();
//            System.out.print("Enter employee role: ");
//            String jobTiltle = new Scanner(System.in).next();
//            employee.setEmployeeNumber(1009);
//            employee.setLastName("empFname");
//            employee.setFirstName("empLname");
//            double ranEx = (int) ((Math.random()*5000)+1);
//            employee.setExtension("x"+ranEx);
//            employee.setEmail("empEmail");
//            employee.setOfficeCode("5");
//            employee.setReportsTo(null);
//            employee.setJobTitle("newbies");
//            em.getTransaction().begin();
//            em.persist(newEmp);
//            em.getTransaction().commit();
//            System.out.println(newEmp);

        }
    }
}
