package sit.int204.classicmodelsservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodelsservice.Entities.Customer;
import sit.int204.classicmodelsservice.Entities.Employee;
import sit.int204.classicmodelsservice.Entities.Office;
import sit.int204.classicmodelsservice.Service.OfficeService;
import sit.int204.classicmodelsservice.dtos.NewOfficeDto;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {
    @Autowired
    private OfficeService service;

    @GetMapping("")
    public List<Office> getAllOffices() {
        return service.getAllOffice();
    }

    @GetMapping("/testarea")
    public  List<NewOfficeDto> getAllofices2(){
        return service.getAllOffice2();
    }

    @GetMapping("/{officeCode}")
    public Office getOfficeById(@PathVariable String officeCode) {
        return service.getOffice(officeCode);
    }

    @GetMapping("/{officeCode}/employees")
    public List<Employee> getOfficeEmployee(@PathVariable String officeCode) {
        return service.getOffice(officeCode).getEmployees();
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
}

