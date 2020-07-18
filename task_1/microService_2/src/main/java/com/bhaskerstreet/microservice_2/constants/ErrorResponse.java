package com.bhaskerstreet.microservice_2.constants;

import com.bhaskerstreet.microservice_2.configurations.AppConfiguration;

public enum ErrorResponse {


    BAD_REQUEST("BAD REQUEST", "1001"),
    METHOD_NOT_SUPPORTED("Incorrect method selection for the resource", "1004"),
    INVALID_JSON("Invalid Json received", "1005");


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
        return AppConfiguration.getAppErrorBaseUrl() + code;

    }

    public String resolveMessage(String... keys) {
        return String.format(message, keys);

    }

}
