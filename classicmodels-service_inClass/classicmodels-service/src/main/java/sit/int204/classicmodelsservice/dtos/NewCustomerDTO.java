package sit.int204.classicmodelsservice.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class NewCustomerDTO {
    @NotNull
    @Min(900)
    private Integer customerNumber;
    @NotEmpty
    @Size(min=5, max = 50)
    private String customerName;
    @Size(min=3, max = 50)
    private String contactFirstName;
    @Size(min=3, max = 50)
    private String contactLastName;
    @Pattern(regexp = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-.]*(\\d{4})(?: *x(\\d+))?\\s*$")
    private String phone;

    @NotNull
    private SimpleEmployeeDTO sales;
    @Min(0) @Max(10000)
    @NotNull(message = "Credit Limit Must be >=0 and <=10,000")
    private Double creditLimit;

}
