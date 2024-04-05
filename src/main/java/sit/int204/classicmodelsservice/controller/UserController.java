package sit.int204.classicmodelsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.classicmodelsservice.entities.Office;
import sit.int204.classicmodelsservice.entities.User;
import sit.int204.classicmodelsservice.service.OfficeService;
import sit.int204.classicmodelsservice.service.UserService;

@RestController
@RequestMapping("classicmodel/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("")
    public User addNewOffice(@RequestBody User user) {
        User thisUser = service.createNewUser(user);
        return  service.getUser(thisUser.getUserId());
    }
}
