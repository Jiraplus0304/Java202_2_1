package sit.int204.classicmodelsservice.controller;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import sit.int204.classicmodelsservice.dtos.NewCustomerDto;
import sit.int204.classicmodelsservice.dtos.PageDTO;
import sit.int204.classicmodelsservice.dtos.NewCustomerDto;


import sit.int204.classicmodelsservice.entities.Customer;
import sit.int204.classicmodelsservice.entities.Customera;
import sit.int204.classicmodelsservice.entities.Order;
import sit.int204.classicmodelsservice.exceptions.ErrorResponse;
import sit.int204.classicmodelsservice.exceptions.GeneralException;
import sit.int204.classicmodelsservice.exceptions.ItemNotFoundException;
import sit.int204.classicmodelsservice.service.CustomerService;
import sit.int204.classicmodelsservice.service.ListMapper;


import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ListMapper listMapper;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerByID(@PathVariable Integer id) {
        Customer customer = service.getCustomerById(id);
        NewCustomerDto simpleCustomer = modelMapper.map(customer, NewCustomerDto.class);
        System.out.println(customer);
        return ResponseEntity.ok(simpleCustomer);
    }

//        @GetMapping("")
//    public List<Customer> getAllCustomer(){
//        return service.getAllCustomer();
//    }
    @GetMapping("")
    public ResponseEntity<Object> getAllCustomer(@RequestParam(defaultValue = "false") boolean pageable,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int pageSize) {
        if (pageable) {
            Page<Customer> customerPage = service.getCustomers(page, pageSize);
            return ResponseEntity.ok(listMapper.toPageDTO(customerPage, NewCustomerDto.class));
        } else
            return ResponseEntity.ok(listMapper.mapList(service.getAllCustomer(), NewCustomerDto.class));
    }

    //    @GetMapping("/{id}")
//    public Customer getAllCustomer(@PathVariable Integer id){
//        return service.getCustomerById(id);
//    }
//    @GetMapping("/{id}/orders")
//    public List<Order> getOrderOfCustomer(@PathVariable Integer id) {
//        return service.getCustomerById(id).getListOrder();
//    }

//    @PostMapping("")
//    public Customer addCustomer(@RequestBody Customer customer) {
//        return service.addCustomer(customer);
//    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        return service.updateCustomer(id, customer);
    }

    @PostMapping("")
    public NewCustomerDto createCustomer(
            @Valid @RequestBody NewCustomerDto newCustomer) {
        System.out.println(newCustomer);
        return service.createCustomer(newCustomer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        service.removeCustomer(id);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleItemNotFound(Exception ex, WebRequest request) {
        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @GetMapping("/test")
    public  List<NewCustomerDto> findAllCustomer(@RequestParam(required = false) String productLine){
        return  service.getAllCustomer();
    }

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public Exception handleOther(Exception exception, WebRequest request){
//        GeneralException generalException = new GeneralException(exception.getMessage());
//        generalException.setTitle("Server Error");
////        generalException.setType(request.getUserPrincipal().);
//        return generalException;
//    }

}
