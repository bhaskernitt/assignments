package com.bhaskerstreet.microservice_2.constants;

public enum ResponseMessages {
    HELLO("Hello");

    private String message;

    ResponseMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
