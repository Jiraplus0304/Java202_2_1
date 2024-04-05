package sit.int204.classicmodelsservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Entity
@Data
@Table(name = "orderdetails")
public class OrderDetail {
    @Id
    private Integer orderNumber;
    @Id
    private String productCode;
    private Integer quantityOrdered;
    private Double priceEach;
    private Integer orderLineNumber;

}
