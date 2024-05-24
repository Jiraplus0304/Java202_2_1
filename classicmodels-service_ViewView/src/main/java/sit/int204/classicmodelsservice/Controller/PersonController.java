package sit.int204.classicmodelsservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.classicmodelsservice.Entities.Person;
import sit.int204.classicmodelsservice.Service.PersonService;

@RestController
@RequestMapping("api/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    @RequestMapping("")
    private Person getPerson(@RequestBody Person person) {
        return  service.createPerson(person);

    }
}
