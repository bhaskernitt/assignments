
package com.bhaskerstreet.microservice_1.exception;

import com.bhaskerstreet.microservice_1.constants.ErrorResponse;
import org.springframework.http.HttpStatus;

public class HttpRequestException extends RootException {

    public HttpRequestException(String message) {
        super(HttpStatus.SERVICE_UNAVAILABLE, message, ErrorResponse.ERROR_OCCURRED_IN_DOWN_STREAM.getErrorUrl());

    }

}