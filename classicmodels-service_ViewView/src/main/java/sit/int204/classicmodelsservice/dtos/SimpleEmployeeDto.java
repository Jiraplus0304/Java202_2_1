package sit.int204.classicmodelsservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import sit.int204.classicmodelsservice.Entities.Office;

@Data
public class SimpleEmployeeDto {
    private Integer id;
    @JsonIgnore
    private String firstName;
    @JsonIgnore
    private String lastName;
    public String getName() {
        return firstName + ' '+ lastName;
    }
}
