package sit.int204.classicmodelsservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.Entities.Customer;
import sit.int204.classicmodelsservice.Entities.Customera;
import sit.int204.classicmodelsservice.Service.CustomeraService;

import java.util.List;

@RestController
@RequestMapping("/customera")
public class CustomeraController {
    @Autowired
    CustomeraService service;

    @PostMapping("")
    public List<Customera> createCustomers(@RequestBody List<Customera> customeras){
        System.out.println("HELLO HEE");
        return service.insertCustomers(customeras);
    }

    @GetMapping("")
    public List<Customera> findAllCustomer(@RequestParam(required = false) String param){
        return service.findAllCustomera(param);
    }
}
