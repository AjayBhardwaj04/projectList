package com.mountan.productList.Exception;

import com.mountan.productList.DTO.exceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class globalExceptionHandlerException {




    @ExceptionHandler(categoryException.class)
    public ResponseEntity<exceptionResponseDTO> globalExceptionHandler(categoryException ex, WebRequest webRequest) {
       exceptionResponseDTO exceptionResponseDTO = new exceptionResponseDTO(
               webRequest.getDescription(false),
               HttpStatus.CONFLICT,
               ex.getMessage(),
               LocalDateTime.now()
       );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponseDTO);
    }

    @ExceptionHandler(categoryNotFound.class)
    public ResponseEntity<exceptionResponseDTO> categoryNotFound(categoryNotFound ex, WebRequest webRequest) {

        exceptionResponseDTO exceptionResponseDTO = new exceptionResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDTO);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<exceptionResponseDTO> handelGlobalException(Exception ex, WebRequest webRequest) {

        exceptionResponseDTO exceptionResponseDTO = new exceptionResponseDTO(
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponseDTO);
    }

}
