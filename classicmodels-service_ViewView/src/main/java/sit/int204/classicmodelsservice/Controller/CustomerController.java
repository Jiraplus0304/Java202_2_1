package sit.int204.classicmodelsservice.Controller;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import sit.int204.classicmodelsservice.Entities.Customer;
import sit.int204.classicmodelsservice.Entities.Product;
import sit.int204.classicmodelsservice.Service.CustomerService;
import sit.int204.classicmodelsservice.Service.ListMapper;
import sit.int204.classicmodelsservice.dtos.LnwzaCustomerDto;
import sit.int204.classicmodelsservice.dtos.NewCustomerDto;
import sit.int204.classicmodelsservice.dtos.SimpleCustomerDTO;
import sit.int204.classicmodelsservice.exception.ErrorResponse;
import sit.int204.classicmodelsservice.exception.GeneralException;
import sit.int204.classicmodelsservice.exception.ItemNotFoundException;
import sit.int204.classicmodelsservice.model.ProductPage;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ListMapper listMapper;
    @GetMapping("/testarea")
    public List<LnwzaCustomerDto> getCustomers2() {
        return service.getAllCustomers2();
    }

    // WK08
//    @GetMapping("")
//    public List<NewCustomerDto> getCustomers() {
//        return service.getAllCustomers();
//    }
    @PostMapping("")
    public NewCustomerDto createCustomer(
            @Valid @RequestBody NewCustomerDto newCustomer) {

        return service.createCustomer(newCustomer);
    }

    @GetMapping("/testQueryByExample")
    public List<NewCustomerDto> findAllCustomer(@RequestParam(required = false) String productLine){
        return service.getAllCustomers();
    }


//    @ExceptionHandler(ItemNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<ErrorResponse> handleItemNotFound(ItemNotFoundException exception, WebRequest request) {
//        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage() + "HEE", request.getDescription(false));
//        System.out.println("HELLO TEST");
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
//    }

////
//        @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public Exception handleOther(Exception exception){
//        GeneralException generalException = new GeneralException(exception.getMessage());
//        generalException.setTitle("Server error Kakkk:");
//        return generalException;
//    }
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<ErrorResponse> handleOther(Exception exception, WebRequest request) {
//        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage() + "HUM", request.getDescription(false));
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
//    }

    @GetMapping("")
    public ResponseEntity<Object> getAllCustomer(
            @RequestParam(defaultValue = "false") Boolean pageble,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize) {
        if (pageble) {
            Page<Customer> customerPage = service.getCustomer(page, pageSize);
            return ResponseEntity.ok(listMapper.toPageDTO(customerPage, SimpleCustomerDTO.class));
        } else {
            return ResponseEntity.ok(listMapper.mapList(service.getCustomer(), SimpleCustomerDTO.class));
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerId(@PathVariable Integer id) {
        Customer customer = service.findByID(id);
            SimpleCustomerDTO simpleCustomer = modelMapper.map(customer, SimpleCustomerDTO.class);
        return ResponseEntity.ok(simpleCustomer);
    }
    @GetMapping("/testarea/{id}")
    public ResponseEntity<Object> getCustomerId2(@PathVariable Integer id){
            Customer customer = service.findByID(id);
            SimpleCustomerDTO simpleCustomer = modelMapper.map(customer,SimpleCustomerDTO.class);
            return ResponseEntity.ok(simpleCustomer);
    }

//    @GetMapping("")
//    public List<Customer> getAllCustomer() {
//        return service.getAllCustomer();
//    }
//
//    @Transactional
//    @GetMapping("/{customerNumber}")
//    public Customer getCustomer(@PathVariable String customerNumber) {
//        return service.getCustomer(customerNumber);
//    }
//    @GetMapping("/{customerNumber}/orders")
//    public List<Order> getCustomerOrder(@PathVariable String customerNumber){
//        return service.getCustomer(customerNumber).getOrders();
//    }
//    @PostMapping("")
//    public Customer addNewCustomer(@RequestBody Customer customer) {
//        return service.createNewCustomer(customer);
//    }
//    @PutMapping("/{customerNumber}")
//    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable String customerNumber) {
//        return service.updateCustomer(customerNumber, customer);
//    }
//    @DeleteMapping("/{customerNumber}")
//    public void removeCustomer(@PathVariable String customerNumber){
//        service.removeCustomer(customerNumber);
//    }

}
