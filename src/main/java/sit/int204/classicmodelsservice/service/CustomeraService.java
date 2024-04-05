package sit.int204.classicmodelsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sit.int204.classicmodelsservice.entities.Customer;
import sit.int204.classicmodelsservice.entities.Customera;
import sit.int204.classicmodelsservice.model.Student;
import sit.int204.classicmodelsservice.repository.CustomeraRepository;

import java.util.List;

@Service
public class CustomeraService {
    @Autowired
    private CustomeraRepository repository;

    public List<Customera> insertCustomera(List<Customera> customeras) {

        return repository.saveAll(customeras);
    }

    public List<Customera> findAllCustomera(String name){
        if(name == null || name.isEmpty() || name.isBlank()){
            return  repository.findAll();
        }
        return repository.findByFirstNameContains(name);
    }
    public List<Customera> findAllCustomera(){
            return  findAllCustomera(null);
    }

}
