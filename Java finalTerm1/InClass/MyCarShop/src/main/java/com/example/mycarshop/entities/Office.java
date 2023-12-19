package com.example.mycarshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table (name = "Offices")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "OFFICE.FIND_ALL", query = "select o from Office o"),
        @NamedQuery(name = "OFFICE.FIND_BY_COUNTRY", query = "select o from Office o where o.country like :countryParam"),
        @NamedQuery(name = "OFFICE.FIND_BY_CITY_OR_COUNTRY",query = "select o from Office o where lower(o.city) like :city or lower(o.country) like :country")
})
        public class Office {
            @Id
            @Column(name = "officeCode" ,nullable = false)
            private String officeCode;
                @Column(name = "addressLine1" ,nullable = false)
            private String addressLine1;
                @Column(name = "addressLine2" ,nullable = false)
            private String addressLine2;
                @Column(name = "city" ,nullable = false)
            private String city;
                @Column(name = "state" ,nullable = false)
            private String state;
                @Column(name = "country" ,nullable = false)
            private String country;
                @Column(name = "postalCode" ,nullable = false)
            private String postalCode;
                @Column(name = "phone" ,nullable = false)
            private String phone;
                @Column(name = "territory" ,nullable = false)
            private String territory;
    @OneToMany(mappedBy = "office",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employeeList;

        }


