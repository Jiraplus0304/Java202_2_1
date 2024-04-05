package sit.int204.classicmodelsservice.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int204.classicmodelsservice.Entities.Customer;
import sit.int204.classicmodelsservice.Entities.Employee;
import sit.int204.classicmodelsservice.Repositories.CustomerRepository;
import sit.int204.classicmodelsservice.Repositories.EmployeeRepository;
import sit.int204.classicmodelsservice.dtos.LnwzaCustomerDto;
import sit.int204.classicmodelsservice.dtos.NewCustomerDto;
import sit.int204.classicmodelsservice.exception.ItemNotFoundException;

import java.util.List;


@Service
public class CustomerService {
    @Autowired
    ModelMapper mapper;
    @Autowired
    ListMapper listMapper;
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private EmployeeRepository employeeRepository;



    public Customer findByID(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new ItemNotFoundException(
                        "CUSTOMER NUMBER NOT FOUND KAK SAWA "+id));
    }
//
//
    public Page<Customer> getCustomer(int page, int size){
        int x  = 10 / 0;
        return  repository.findAll(PageRequest.of(page,size));
    }
//
    public List<Customer> getCustomer(){
        return repository.findAll();
    }
//    public List<Customer> getAllCustomer(){
//        return repository.findAll();
//    }
//    public Customer getCustomer(Integer customerNumber){
//        return repository.findById(customerNumber).orElseThrow(
//                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND,
//                        "Customer Id " + customerNumber + " DOES NOT EXIST !!!") {
//                }
//        );
//    }
//    @Transactional
//    public Customer createNewCustomer(Customer customer) {
//        return repository.save(customer);
//    }
//    @Transactional
//    public Customer updateCustomer(Integer customerNumber, Customer customer) {
//        if(customer.getCustomerNumber()!=null) {
//            if (!customer.getCustomerNumber().equals(customerNumber)) {
//                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
//                        "Conflict Office code  !!! (" + customerNumber +
//                                " vs " + customer.getCustomerNumber() + ")");
//            }
//        }
//        Customer existingCustomer = repository.findById(customerNumber).orElseThrow(
//                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND,
//                        "Customer Number" + customerNumber + " DOES NOT EXIST !!!"));
//        return repository.save(customer);
//    }
//    @Transactional
//    public void removeCustomer(Integer customerNumber) {
//        Customer customer = repository.findById(customerNumber).orElseThrow(
//                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Customer Number " + customerNumber + " DOES NOT EXIST !!!")
//        );
//        repository.delete(customer);
//    }

    // WK08
    public NewCustomerDto createCustomer(NewCustomerDto newCustomer) {
        if (repository.existsById(newCustomer.getCustomerNumber())) {
            System.out.println("KUYKUY");
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Duplicate customer for id " +
                    newCustomer.getCustomerName());
        }
        System.out.println("HELLO WORLD ZA");
        Customer customer = mapper.map(newCustomer, Customer.class);
        Employee e = employeeRepository.findById(newCustomer.getSales().getId()).orElseThrow(
                () -> new ItemNotFoundException("Employee number" + newCustomer.getSales().getId() + " does not exist !!!")
        );
        customer.setSales(e);
        System.out.println(customer);
        return mapper.map(repository.saveAndFlush(customer), NewCustomerDto.class);
    }

    public List<NewCustomerDto> getAllCustomers() {
        Customer c = new Customer();
        c.setState("CA");
        List<Customer> customers = repository.findAll(Example.of(c));
        return listMapper.mapList(customers, NewCustomerDto.class, mapper);
//        return listMapper.mapList(repository.findAll(), NewCustomerDto.class, mapper);
    }
    public List<LnwzaCustomerDto> getAllCustomers2() {
        return listMapper.mapList(repository.findAll(), LnwzaCustomerDto.class, mapper);
    }

}

