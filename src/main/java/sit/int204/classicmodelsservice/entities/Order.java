package sit.int204.classicmodelsservice.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@ToString
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "orderNumber", nullable = false)
    private Integer orderNumber;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String status;
    private String comments;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customerNumber", insertable = false, updatable = false)
    private Customer customer;



}

