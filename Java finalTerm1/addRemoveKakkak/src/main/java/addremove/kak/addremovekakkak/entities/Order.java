package addremove.kak.addremovekakkak.entities;

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
    @Column(name = "orderNumber",nullable = false)
    private Integer id;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
    private String status;
    private String comments;

    @ManyToOne
    @JoinColumn(name = "customerNumber" ,insertable = false,updatable = false)
    private Customer orderByCustomer;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetails> Ordered;


}
