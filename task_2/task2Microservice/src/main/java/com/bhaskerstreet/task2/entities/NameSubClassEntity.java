package com.bhaskerstreet.task2.entities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public class NameSubClassEntity implements Serializable {

    private String subclasses;
    private String name;
    private Integer id;
    private transient boolean toBeIgnored;


    public NameSubClassEntity(String subclasses, String name, Integer id) {

        this.subclasses = subclasses;
        this.name = name;
        this.id = id;
    }


    public String getSubclasses() {
        return subclasses;
    }

    public void setSubclasses(String subclasses) {
        this.subclasses = subclasses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isToBeIgnored() {
        return toBeIgnored;
    }

    public void setToBeIgnored(boolean toBeIgnored) {
        this.toBeIgnored = toBeIgnored;
    }

    @Override
    public String toString() {

        ObjectMapper mapper = new ObjectMapper();

        return "NameSubClassEntity{}";
    }
}
