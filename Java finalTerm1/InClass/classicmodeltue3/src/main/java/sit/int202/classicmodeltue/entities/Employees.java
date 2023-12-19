package sit.int202.classicmodeltue.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "employees")
@Getter
@Setter
@NamedQueries(
        {
                @NamedQuery(name = "EMPLOYEE.FIND_ALL",query = "select e from Employees e"),
                @NamedQuery(name = "EMPLOYEE.FIND_BY_NAME",query = "select e from Employees e where e.firstName like :first_name OR "
                + "e.lastName like :last_name")
        }
)
public class Employees {
    @Id
    private Integer employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
//    private String officeCode;
//    private Integer reportsTo;
    private String jobTitle;
    @ManyToOne
    @JoinColumn(name = "officecode",insertable = false,updatable = false)
    private Office office;
}
