package com.bhaskerstreet.microservice_1.constants;

import com.bhaskerstreet.microservice_1.configuration.AppConfig;

public enum ErrorResponse {


    BAD_REQUEST("BAD REQUEST", "1001"),
    METHOD_NOT_SUPPORTED("Incorrect method selection for the resource", "1004"),
    INVALID_JSON("Invalid Json received", "1005"),
    COMMUNICATION_FAILURE("Communication error/Service Unavailable", "2000"),
    ERROR_OCCURRED_IN_DOWN_STREAM("Error occurred in downstream system", "3000");


    private String message;
    private String code;


    ErrorResponse(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;

    }

    public String getErrorUrl() {
        return AppConfig.getAppErrorBaseUrl() + code;

    }

    public String resolveMessage(String... keys) {
        return String.format(message, keys);

    }

}
