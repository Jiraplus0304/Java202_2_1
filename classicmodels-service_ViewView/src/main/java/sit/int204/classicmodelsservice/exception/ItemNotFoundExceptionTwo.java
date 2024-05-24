package sit.int204.classicmodelsservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class ItemNotFoundExceptionTwo extends ResponseStatusException {
    public ItemNotFoundExceptionTwo(String message){
        super(HttpStatus.NOT_FOUND,message);
    }
}
