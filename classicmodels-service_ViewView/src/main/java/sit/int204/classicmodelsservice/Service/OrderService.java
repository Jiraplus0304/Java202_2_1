package sit.int204.classicmodelsservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelsservice.Entities.Order;
import sit.int204.classicmodelsservice.Repositories.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> getAllOrder() {
        return repository.findAll();
    }
}
