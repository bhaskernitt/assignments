package com.bhaskerstreet.microservice_1.dtos;

public class ConcatenatedResponse {
    public ConcatenatedResponse(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
