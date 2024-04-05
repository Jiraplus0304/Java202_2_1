package sit.int204.classicmodelsservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.entities.Customera;
import sit.int204.classicmodelsservice.service.CustomeraService;

import java.util.List;

@RestController
@RequestMapping("/api/customera")
public class CustomeraCotroller {
    @Autowired
    private CustomeraService service;


    @PostMapping("")
    public List<Customera> createCustomera(@RequestBody List<Customera> customeras) {
        return service.insertCustomera(customeras);
    }

    @GetMapping("")
    // @RequestParam(name = "x" , required = false) name mean front must sent variavble name is "x" and require mean u may send request or not send
    public List<Customera> getAllCustomera(@RequestParam(name = "x" , required = false) String param) {
        //If does not set name front must send variable name exact with parameter name in this term is "param"
        return  service.findAllCustomera(param);

    }






}
