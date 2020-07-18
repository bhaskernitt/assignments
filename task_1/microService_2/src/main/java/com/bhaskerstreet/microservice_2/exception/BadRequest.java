package com.bhaskerstreet.microservice_2.exception;

import org.springframework.http.HttpStatus;

public class BadRequest extends RootException {

    public BadRequest(String message, String errorUrl) {
        super(HttpStatus.BAD_REQUEST, message, errorUrl);


    }


}
