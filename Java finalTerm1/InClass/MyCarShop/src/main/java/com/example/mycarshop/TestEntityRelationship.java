package com.example.mycarshop;

import com.example.mycarshop.entities.Employee;
import com.example.mycarshop.entities.Office;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class TestEntityRelationship {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("classic-models");
        EntityManager em = emf.createEntityManager();
        List<Office> officeList = em.createNamedQuery("OFFICE.FIND_ALL").getResultList();
        for (Office office : officeList){
            System.out.printf("%-3s %-25s %-15s %-20s\n",
                    office.getOfficeCode(),office.getAddressLine1(),
                    office.getCity(),office.getCountry());
            System.out.println("---------------------------------");
            for (Employee employee :office.getEmployeeList() ){
                System.out.printf("%-4d %-25s %-15s %-20s\n",
                        employee.getId(),employee.getFirstName(),
                        employee.getLastName(),employee.getJobTitle(),employee.getOffice().getCity());
            };
            System.out.println();
        };

    }
}
