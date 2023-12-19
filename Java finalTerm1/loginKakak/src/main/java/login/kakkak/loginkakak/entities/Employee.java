package login.kakkak.loginkakak.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@Entity
@ToString
@Table(name = "employees")
@NamedQueries(
        @NamedQuery(name = "EMOPLOYEE.FINDALL",query = "select e from Employee e")
//        @NamedQuery(name = "OFFICE.FIND_ALL",query = "select o from Office o")
//        @NamedQuery(name = "OFFICE.FIND_BY_COUNTRY",query = "select o from Office o where o.country like :countryParam")
)
public class Employee {
    @Id
    @Column(name = "employeeNumber",nullable = false)
    private Integer id;
    private String firstName;
    private String lastName;
    private String extension;
    private String email;
    private String officeCode;
    private String jobTitle;

    @OneToMany(mappedBy = "salesRepEmployee",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Customer> customerList;

    @OneToMany(mappedBy = "reportToEmployee",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> reportedTo;

    @ManyToOne
    @JoinColumn(name = "reportsTo" ,insertable = false,updatable = false)
    private  Employee reportToEmployee;


    @ManyToOne
    @JoinColumn(name = "officeCode" ,insertable = false,updatable = false)
    private  Office office;

}
