package sit.int204.classicmodelsservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data

public class NewSimpleEmployeeDTO {
    @NotEmpty
    private Integer id;
    @JsonIgnore
    private String firstName;
    @JsonIgnore
    private String lastName;
    public String getFullName() {
        return firstName + " "+ lastName;
    }

}
