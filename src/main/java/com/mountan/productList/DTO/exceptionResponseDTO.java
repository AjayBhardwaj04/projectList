package com.mountan.productList.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class exceptionResponseDTO {
    private String apiPath;
    private HttpStatus httpCode;
    private  String errorMessage;
    private LocalDateTime errorTime;
}
