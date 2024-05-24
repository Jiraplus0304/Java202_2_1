package sit.int204.classicmodelsservice.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralException extends Exception{
    private String title;

    public GeneralException(String message) {
        super(message);
    }
}
