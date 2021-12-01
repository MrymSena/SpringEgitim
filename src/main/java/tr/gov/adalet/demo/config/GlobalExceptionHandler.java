package tr.gov.adalet.demo.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler {


    public static ResponseEntity<Map<String,String>> handleValidationException(
            MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error ->
        {
            String propertyName =((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(propertyName, errorMessage);
        });
    return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
    }

}
