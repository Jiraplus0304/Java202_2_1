package sit.int204.classicmodelsservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleEmployeeDTO {
    private String firstname;
    private String lastname;
    private String officeCity;
    public String getName(){
        return firstname + ' '+lastname;
    }
}
