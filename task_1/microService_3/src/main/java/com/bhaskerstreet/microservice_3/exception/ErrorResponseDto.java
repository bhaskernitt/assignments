package com.bhaskerstreet.microservice_3.exception;

public class ErrorResponseDto {

    private int httpStatus;
    private String message;
    private String errorUrl;

    public ErrorResponseDto(int httpStatus, String message, String errorUrl) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.errorUrl = errorUrl;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorUrl() {
        return errorUrl;
    }

    public void setErrorUrl(String errorUrl) {
        this.errorUrl = errorUrl;
    }
}
