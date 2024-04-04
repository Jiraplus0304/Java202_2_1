package sit.int204.classicmodelsservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsservice.entities.Customer;
import sit.int204.classicmodelsservice.repositories.CustomerRepositories;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepositories repositories;

    public Customer findByID(Integer id){
        return repositories.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "customer number" + id +"doesn't exist!!!!!!"));
    }

    public Page<Customer> getCustomers(int page, int Size){
        return repositories.findAll(PageRequest.of(page, Size));
    }

    public List<Customer> getCustomers(){
        return repositories.findAll();
    }
}

