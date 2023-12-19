package login.kakkak.loginkakak.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Table(name = "products")
@Entity
@NamedQueries({
        @NamedQuery(name = "PRODUCT.FindAll", query = "SELECT p FROM Product p"),
        @NamedQuery(name = "PRODUCT.count", query = "SELECT count(p) as count FROM Product p")
})
public class Product {
    @Id
    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private Integer quantityInStock;
    private Double buyPrice;
    @Column(name = "MSRP")
    private Double price;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetails> Ordered;


}
