package sit.int204.classicmodelsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.entities.Employee;
import sit.int204.classicmodelsservice.entities.Office;
import sit.int204.classicmodelsservice.model.Count;
import sit.int204.classicmodelsservice.service.OfficeService;

import java.util.List;
import java.util.Set;

// "RestController" will sent data as json. if u write "controller" it mean mvc controller
@RestController

@RequestMapping("/api/offices")
public class OfficeController {
    @Autowired
    private OfficeService service;

    @GetMapping("")
    public List<Office> getAllOffices(@RequestParam(required = false) String[] param) {
        return service.getAllOffice(param);
    }

    @GetMapping("/{officeCode}")

    public Office getOfficeById(@PathVariable String officeCode) {
        return service.getOffice(officeCode);
    }

    @PostMapping("")

    public Office addNewOffice(@RequestBody Office office) {
        return service.createNewOffice(office);
    }

    @PutMapping("/{officeCode}")
    public Office updateOffice(@RequestBody Office office, @PathVariable String officeCode) {
        return service.updateOffice(officeCode, office);
    }

    @DeleteMapping("/{officeCode}")
    public void removeOffice(@PathVariable String officeCode) {
        service.removeOffice(officeCode);
    }

    @GetMapping("/count")
    public Count getOfficeCount(){
        return  service.getOfficeCount();
    }

    @GetMapping("/{officeCode}/employees")
    public Set<Employee> getEmployeeInOffice(@PathVariable String officeCode){
        Office office = service.getOffice(officeCode);
        return  office.getEmployees();
    }
}

