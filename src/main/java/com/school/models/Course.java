package com.school.models;

public class Course {

    private String name;
    private Integer id;

    // temporary constructor
    public Course(String name) {
        this.id = 1;
        this.name = name;
    }

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
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

}