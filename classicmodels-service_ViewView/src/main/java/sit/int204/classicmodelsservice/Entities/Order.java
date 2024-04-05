    package sit.int204.classicmodelsservice.Entities;

    import com.fasterxml.jackson.annotation.JsonIgnore;
    import jakarta.persistence.*;
    import lombok.Data;

    import java.util.LinkedHashSet;
    import java.util.Set;

    @Data
    @Entity
    @Table(name = "orders")
    public class Order {
        @Id
        private String orderNumber;
        private String orderDate;
        private String requiredDate;
        private String shippedDate;
        private String status;
        private String comments;

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "customerNumber")
        private Customer customer;

    }
