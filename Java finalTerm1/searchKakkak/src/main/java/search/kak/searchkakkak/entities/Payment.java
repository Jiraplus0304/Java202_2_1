package search.kak.searchkakkak.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@Entity
@ToString
@Table(name = "payments")
public class Payment {
    @Id
    @ManyToOne
    @JoinColumn(name = "customerNumber",nullable = false)
    private Customer customer;
    @Id
    @Column(name = "checkNumber",nullable = false)
    private String checkNumber;
    private Date paymentDate;
    private Double amount;

}
