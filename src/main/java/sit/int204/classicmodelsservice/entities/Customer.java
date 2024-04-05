package sit.int204.classicmodelsservice.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import sit.int204.classicmodelsservice.entities.Employee;
import sit.int204.classicmodelsservice.entities.Order;

import java.util.List;


@Getter
@Setter
@Table(name = "customers")
@Entity
public class Customer {
    @Id
    @Column(name = "customerNumber",nullable = false)
    private Integer customerNumber;
    private String customerName;
    @Column(name = "contactLastName", nullable = false, length = 50)
    private String contactLastName;
    @Column(name = "contactFirstName", nullable = false, length = 50)
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String role;
    private String password;

    private Double creditLimit;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "salesRepEmployeeNumber" ,insertable = false,updatable = false)
    private Employee salesRepEmployee;

    @JsonIgnore
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> listOrder;

}



