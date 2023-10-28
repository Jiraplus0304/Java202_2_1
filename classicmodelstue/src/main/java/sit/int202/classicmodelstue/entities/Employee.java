package sit.int202.classicmodelstue.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Employees")
@Getter
@Setter
@ToString
@NamedQueries({
        @NamedQuery(name = "EMPLOYEE.FIND_ALL",query="select e from Employee e"),
        @NamedQuery(name = "EMPLOYEE.FIND_BY_NAME",
                query = "select e from Employee e where e.firstName like:first_name OR "
        +"e.lastName like:last_name")
})
public class Employee {
    @Id
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String officeCode;
    private String reportsTo;
    private String jobTitle;

}
