package com.mountan.productList.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class globalExceptionHandlerException {
@ExceptionHandler(categoryException.class)
    public ResponseEntity<String> globalExceptionHandler(categoryException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(categoryNotFound.class)
    public ResponseEntity<String> categoryNotFound(categoryNotFound ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}
