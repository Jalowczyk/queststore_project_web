package com.school.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CourseTest {

    private Course course;

    @BeforeEach
    public void before() {
        course = new Course("name");
    }

}
