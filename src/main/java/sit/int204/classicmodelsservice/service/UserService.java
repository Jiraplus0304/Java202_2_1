package sit.int204.classicmodelsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import sit.int204.classicmodelsservice.entities.Office;
import sit.int204.classicmodelsservice.entities.User;
import sit.int204.classicmodelsservice.repository.OfficeRepository;
import sit.int204.classicmodelsservice.repository.UserRepository;
@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Transactional
    public User createNewUser(User user
    ) {
        calGrade(user);
        return repository.save(user);
    }

    private void calGrade(User user){
        user.calGrade();
    }

    public User getUser(Integer userId) {
        return repository.findById(userId).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Office Id " + userId + " DOES NOT EXIST !!!") {
                });
    }



}
