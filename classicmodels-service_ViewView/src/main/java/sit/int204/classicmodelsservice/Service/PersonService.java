package sit.int204.classicmodelsservice.Service;

import org.springframework.stereotype.Service;
import sit.int204.classicmodelsservice.Entities.Person;

@Service
public class PersonService {

    public Person createPerson(Person personParam){
        Person person = new Person();
        person.setName(personParam.getName());
        person.setId(personParam.getId());
        person.setScore(personParam.getScore());
        if(personParam.getScore() >= 80){
            person.setGrade("A");
        } else if (personParam.getScore() >= 70) {
            person.setGrade("B");
        } else if (personParam.getScore() >= 60) {
            person.setGrade("C");
        } else if (personParam.getScore() >= 50) {
            person.setGrade("D");
        }else personParam.setGrade("F");
        return  person;
    }

}
