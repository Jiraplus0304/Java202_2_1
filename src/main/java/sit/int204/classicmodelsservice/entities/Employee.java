package sit.int204.classicmodelsservice.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "employees")

public class Employee {
    @Id
    @JoinColumn(name = "employeeNumber",nullable = false)
    private Integer employeeNumber;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "officeCode")
    private Office office;
    @Column(name = "lastName", nullable = false, length = 50)
    private String lastName;
    @Column(name = "firstName", nullable = false, length = 50)
    private String firstName;
    @Column(name = "extension", nullable = false, length = 10)
    private String extension;
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @OneToMany(mappedBy = "salesRepEmployee")
    private List<Customer> listCustomers;

    @Column(name = "jobTitle", nullable = false, length = 50)
    private String jobTitle;
}


