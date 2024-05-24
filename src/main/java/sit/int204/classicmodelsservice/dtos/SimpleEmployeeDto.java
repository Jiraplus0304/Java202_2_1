package sit.int204.classicmodelsservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleEmployeeDto {
    @NonNull
    private Integer employeeNumber;
    @JsonIgnore
    private String firstName;
    @JsonIgnore
    private String lastName;
    public String getName() {
        return firstName + ' '+ lastName;
    }
}
