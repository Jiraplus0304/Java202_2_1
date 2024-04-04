package sit.int204.classicmodelsservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservice.entities.Customer;

public interface CustomerRepositories  extends JpaRepository<Customer,Integer> {
}
