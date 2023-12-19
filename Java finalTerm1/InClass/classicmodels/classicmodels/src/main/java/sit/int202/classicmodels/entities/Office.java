package sit.int202.classicmodels.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = {"territory", "addressLine2", "postalCode"})
@Entity
@Table(name = "offices")
@NamedQueries({
        @NamedQuery(name = "OFFICE.FIND_ALL", query = "select o from Office o"),
        @NamedQuery(name = "OFFICE.FIND_BY_COUNTRY",
                query = "select o from Office o where o.country like :country"),
        @NamedQuery(name = "OFFICE.FIND_BY_CITY_OR_COUNTRY",
                query = "select o from Office o where lower(o.city) like :city or lower(o.country) like :country")
})
public class Office {
    @Id
    private String officeCode;
    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;
}
