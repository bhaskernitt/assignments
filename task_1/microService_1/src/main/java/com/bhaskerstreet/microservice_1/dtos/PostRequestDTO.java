package com.bhaskerstreet.microservice_1.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequestDTO {

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Surname")
    private String surname;

    public PostRequestDTO() {
    }

    public PostRequestDTO(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    @Override
    public String toString() {
        return "PostRequestDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
