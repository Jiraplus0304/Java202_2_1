package sit.int204.classicmodelsservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import sit.int204.classicmodelsservice.Entities.Employee;

@Data
public class LnwzaCustomerDto {
    private Integer customerNumber;
    @JsonIgnore
    private String contactFirstName;
    @JsonIgnore
    private String contactLastName;
    public String getmergeName(){
        return contactFirstName +" KUY "+ contactLastName;
    }
    private SimpleEmployeeDto sales;
}
