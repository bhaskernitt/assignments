package com.bhaskerstreet.task2.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Name",
        "Sub Classes"
})
public class Response {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("Sub Classes")
    private List<Response> subClasses;

    public Response(String name, List<Response> subClasses) {
        this.name = name;
        this.subClasses = subClasses;
    }

    public Response(String name) {
        this.name = name;
    }

    public Response() {
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }


    @JsonProperty("Sub Classes")
    public List<Response> getSubClasses() {
        return subClasses;
    }

    @JsonProperty("Sub Classes")
    public void setSubClasses(List<Response> subClasses) {
        this.subClasses = subClasses;
    }

    @Override
    public String toString() {
        return "Response{" +
                "name='" + name + '\'' +
                ", subClasses=" + subClasses +
                '}';
    }
}


