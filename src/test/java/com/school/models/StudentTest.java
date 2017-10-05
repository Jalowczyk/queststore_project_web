package com.school.models;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student student;

    @BeforeEach
    public void before() {
        this.student = new Student("Adam", "Kowalski", "adam@gmail.com", "xxx", "student");
    }

}