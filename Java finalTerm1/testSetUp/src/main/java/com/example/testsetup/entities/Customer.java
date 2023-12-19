package com.example.testsetup.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "customers")
@NamedQueries({
//        @NamedQuery(name = "INSERT_NAME_EMAIL", query = "")
        @NamedQuery(name = "CUSTOMER.FIND_USER",
                query = "SELECT c FROM Customer c WHERE customerName = :user_account"),
        @NamedQuery(name = "CUSTOMER.FIND_ALL", query = "select c from Customer c")
})
public class Customer {
    @Id
    private Integer customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private Integer salesRepEmployeeNumber;
    private Double creditLimit;
    private String password;
}
