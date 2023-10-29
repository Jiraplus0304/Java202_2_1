package sit.int202.random_number_calculator.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RandomNumber {
    private int num1 = (int) (Math.random() * 100) ;
    private int num2 = (int) (Math.random() * 100) ;
    private int result = num1+ num2;
}
