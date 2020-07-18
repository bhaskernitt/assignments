package com.bhaskerstreet.microservice_1.constants;

public enum ApplicationStatuses {

    UP("Up"),
    DOWN("Down");

    private String status;

    ApplicationStatuses(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
