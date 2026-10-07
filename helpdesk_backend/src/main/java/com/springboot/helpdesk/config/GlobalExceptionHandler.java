package com.springboot.helpdesk.config;

import com.springboot.helpdesk.dto.response.ErrorDto;
import com.springboot.helpdesk.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestControllerAdvice // it is a global handling of controllers in a project
                    //especially for exception over controllers
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException e){
        //1.simply check the response without DTO
//        return ResponseEntity
//                .badRequest()
//                .body(e.getMessage());
        // spring.jackson only convert object into JSON
        // so wee need an object that why we're creating DTO here

        // 2. response with DTO
        return
                ResponseEntity
                        .badRequest()
                        .body(new
                                ErrorDto(
                                        e.getMessage(),
                                "Id is not found in the DB",
                                            Instant.now()
                        ));

        //3.response as object but it shows 200 ok since it consider object as correct response
//        return new ErrorDto(
//                                    e.getMessage(),
//                                "Id is not found in the DB",
//                                            Instant.now()
//                        );
    }

    @ExceptionHandler
    public ResponseEntity<Map<String , String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        Map<String , String> map = new HashMap<>();
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> list = bindingResult.getFieldErrors();

        list.forEach(
                fieldError -> map.put(fieldError.getField() , fieldError.getDefaultMessage())
        );

        //since it may have different errors from single request,
        // we can go with MAP
        return ResponseEntity
                .badRequest()
                .body(map);
    }

}
