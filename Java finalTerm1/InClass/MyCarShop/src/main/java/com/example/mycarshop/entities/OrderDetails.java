package com.example.mycarshop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Entity
@ToString
@Table(name = "orderdetails")
public class OrderDetails {
    @Id
    @ManyToOne
    @JoinColumn(name = "orderNumber" ,insertable = false,updatable = false)
    private Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "productCode" ,insertable = false,updatable = false)
    private Product product;
    private Integer quantityOrdered;
    private  Double priceEach;
    private  Integer orderLineNumber;



}
