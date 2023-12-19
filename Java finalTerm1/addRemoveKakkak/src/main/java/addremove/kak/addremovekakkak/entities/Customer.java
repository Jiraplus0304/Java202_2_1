package addremove.kak.addremovekakkak.entities;

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
        @NamedQuery(name = "FIND_USER", query = "SELECT c FROM Customer c WHERE concat(trim(c.contactFirstName), ' ', trim(c.contactLastName)) = :user_account"),
        @NamedQuery(name = "SEARCH", query = "SELECT c FROM Customer c WHERE c.customerName LIKE CONCAT('%', :keyword, '%') OR CONCAT(TRIM(c.contactFirstName), ' ', TRIM(c.contactLastName)) LIKE CONCAT('%', :keyword, '%') or c.customerNumber = :keyword"),
        @NamedQuery(name = "FIND_CUS", query = "SELECT c FROM Customer c WHERE c.customerNumber = :id")

})
public class Customer {
    @Id
    @Column(name = "customerNumber",nullable = false)
    private String customerNumber;
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
