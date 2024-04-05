package sit.int204.classicmodelsservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservice.Entities.Order;

public interface OrderRepository extends JpaRepository<Order,String> {
}
