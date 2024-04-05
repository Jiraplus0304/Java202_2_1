package sit.int204.classicmodelsservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sit.int204.classicmodelsservice.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
        @Query("select c from Customer c where concat(c.contactFirstName,' ',c.contactLastName) = :name")
        Customer findByName(String name);
}
