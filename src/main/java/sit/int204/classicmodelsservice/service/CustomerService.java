package sit.int204.classicmodelsservice.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsservice.dtos.NewCustomerDto;
import sit.int204.classicmodelsservice.entities.Customer;

import sit.int204.classicmodelsservice.entities.Employee;
import sit.int204.classicmodelsservice.exceptions.ItemNotFoundException;
import sit.int204.classicmodelsservice.repository.CustomerRepository;
import sit.int204.classicmodelsservice.repository.EmployeeRepository;

import java.util.List;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;
    @Autowired
    ModelMapper mapper;
    @Autowired
    ListMapper listMapper;

    @Autowired
    EmployeeRepository employeeRepository;

    public List<NewCustomerDto> getAllCustomer() {
        Customer c = new Customer();
        c.setState("CA"); //กรองค่า
        c.setCity("pa"); //กรองค่า
        ExampleMatcher matcher = ExampleMatcher.matchingAny() // OR
                .withMatcher("country",ignoreCase().contains())
                .withMatcher("city",ignoreCase().contains());
        List<Customer> customers = repository.findAll(Example.of(c,matcher));
        return listMapper.mapList(customers,NewCustomerDto.class);
    }

    public Customer getCustomerById(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new ItemNotFoundException("404 customer Id " + id + " DOES NOT EXIST !!!") {
                });
    }

    @Transactional
    public Customer addCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Transactional
    public Customer updateCustomer(Integer id, Customer customer) {
        if (customer.getCustomerNumber() != null) {
            if (!customer.getCustomerNumber().equals(id)) {
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Conflict customer code  !!! (" + id + " vs " + customer.getCustomerNumber() + ") ");
            }
        }
        repository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, " customer Id" + id + " DOES NOT EXIST !!!"));
        return repository.save(customer);
    }

    @Transactional
    public NewCustomerDto createCustomer(NewCustomerDto newCustomer) {
        if (repository.existsById(newCustomer.getCustomerNumber())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Duplicate customer for id " +
                    newCustomer.getCustomerNumber());
        }
        Customer customer = mapper.map(newCustomer, Customer.class);

        System.out.println(repository.findById(103));
//        Employee e = employeeRepository.findById(newCustomer.getSales().getEmployeeNumber()).orElseThrow(() -> new ItemNotFoundException("Employee number " + newCustomer.getSales().getEmployeeNumber() + "dose not exist !!!"));
//        customer.setSales(e);
        System.out.println(customer);
        return mapper.map(repository.save(customer), NewCustomerDto.class);
    }

    //    public List<NewCustomerDto> getAllCustomers() {
//        return listMapper.mapList(repository.findAll(), NewCustomerDto.class, mapper); }
    @Transactional
    public void removeCustomer(Integer id) {
        Customer customer = repository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Office Id " + id + " DOES NOT EXIST !!!"));
        repository.delete(customer);
    }

    public Page<Customer> getCustomers(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

}
