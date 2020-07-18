package com.bhaskerstreet.task2.exception;


import com.bhaskerstreet.task2.annotations.LogMethodParam;
import com.bhaskerstreet.task2.constants.ErrorResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger();

    @org.springframework.web.bind.annotation.ExceptionHandler(BadRequest.class)
    @LogMethodParam
    public ResponseEntity badRequest(RootException e) {
        LOGGER.error(e);
        return sendErrorResponse(new ErrorResponseDto(e.getHttpStatus().value(),
                e.getMessage(),
                e.getErrorUrl()), e.getHttpStatus());

    }


    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @LogMethodParam
    public ResponseEntity forAllExceptions(Exception e) {
        LOGGER.error(e);
        return sendErrorResponse(new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(),
                ErrorResponse.BAD_REQUEST.getMessage(),
                ErrorResponse.BAD_REQUEST.getErrorUrl()), HttpStatus.BAD_REQUEST);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @LogMethodParam
    public ResponseEntity methodNotSupported() {
        return sendErrorResponse(new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(),
                ErrorResponse.METHOD_NOT_SUPPORTED.getMessage(),
                ErrorResponse.METHOD_NOT_SUPPORTED.getErrorUrl()), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    @LogMethodParam
    public ResponseEntity invalidJson() {
        return sendErrorResponse(new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(),
                ErrorResponse.INVALID_JSON.getMessage(),
                ErrorResponse.INVALID_JSON.getErrorUrl()), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NotFound.class)
    @LogMethodParam
    public ResponseEntity notFound(RootException e) {
        return sendErrorResponse(new ErrorResponseDto(e.getHttpStatus().value(),
                e.getMessage(),
                e.getErrorUrl()), e.getHttpStatus());

    }


    private ResponseEntity sendErrorResponse(ErrorResponseDto errorResponseDto, HttpStatus httpStatus) {

        return new ResponseEntity<>(errorResponseDto, httpStatus);
    }

}
