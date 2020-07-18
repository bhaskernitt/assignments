package com.bhaskerstreet.microservice_1.exception;

import org.springframework.http.HttpStatus;

public class BadRequest extends RootException {

    public BadRequest(String message, String errorUrl) {
        super(HttpStatus.BAD_REQUEST, message, errorUrl);


    }


}
