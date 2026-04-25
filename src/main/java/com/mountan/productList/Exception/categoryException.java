package com.mountan.productList.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class categoryException extends RuntimeException{
    public categoryException(String message) {

        super(message);
    }

}
