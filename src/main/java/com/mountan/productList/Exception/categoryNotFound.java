package com.mountan.productList.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class categoryNotFound extends RuntimeException {
    public categoryNotFound(String message) {
        super(message);
    }

}
