package sit.int204.classicmodelsservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "productlines")
@Entity
public class ProductLine {
    @Id
    private  String productLine;
    private  String textDescription;
    private  String htmlDescription;




}
