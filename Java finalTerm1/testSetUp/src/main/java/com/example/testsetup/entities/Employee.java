package com.example.testsetup.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "employees")
@NamedQueries({
    @NamedQuery(name = "EMPLOYEE_FIND_ALL", query = "select e from Employee e")
})

public class Employee {
    @Id
    private Integer employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
//    private String officeCode;
    private  String jobTitle;

}
