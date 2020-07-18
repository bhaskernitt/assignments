package com.bhaskerstreet.task2.exception;

import org.springframework.http.HttpStatus;

public class RootException extends Exception {

    private HttpStatus httpStatus;
    private String message;
    private String errorUrl;

    public RootException(HttpStatus httpStatus, String message, String errorUrl) {

        this.httpStatus = httpStatus;
        this.message = message;
        this.errorUrl = errorUrl;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }


    public String getMessage() {
        return message;
    }


    public String getErrorUrl() {
        return errorUrl;
    }

}
