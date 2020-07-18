package com.bhaskerstreet.task2.exception;

import org.springframework.http.HttpStatus;

public class NotFound extends RootException {

    public NotFound(String message, String errorUrl) {
        super(HttpStatus.NOT_FOUND, message, errorUrl);
    }


}
