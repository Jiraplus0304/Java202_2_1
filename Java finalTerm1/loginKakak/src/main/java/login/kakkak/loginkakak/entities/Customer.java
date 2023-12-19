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
@Table(name = "customers")
@NamedQueries({
        @NamedQuery(name = "FIND_USER", query = "SELECT c FROM Customer c WHERE c.contactFirstName = :user_account")
})
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
    private Double creditLimit;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> paymented;

    @ManyToOne
    @JoinColumn(name = "salesRepEmployeeNumber" ,insertable = false,updatable = false)
    private Employee salesRepEmployee;

    @OneToMany(mappedBy = "orderByCustomer",cascade = CascadeType.ALL, orphanRemoval = true)
   private  List<Order> listOrder;

}
