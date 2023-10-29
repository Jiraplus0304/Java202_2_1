package sit.int202.classicmodels.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "employees")
@NamedQueries(
        @NamedQuery(name = "EMPLOYEE.FIND_ALL",query = "select emp from employees emp")
)
public class Employee {
    @Id
    @Column(name = "employeeNumber" ,nullable = false)
    private int id;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String officeCode;
    private String reportsTo;
    private String jobTitle;
}
