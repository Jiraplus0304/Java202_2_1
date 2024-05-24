package sit.int204.classicmodelsservice.dtos;

import lombok.Data;
import sit.int204.classicmodelsservice.Entities.Employee;

import java.util.List;

@Data
public class NewOfficeDto {
    private String officeCode;
    private String city;
    private String country;
    private List<Employee> employees;

}
