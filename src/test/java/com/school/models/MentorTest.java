package com.school.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MentorTest {

    private Mentor mentor;

    @BeforeEach
    public void before() {
        this.mentor = new Mentor("Mateusz", "Ostafil", "password", "mat@gmail.com", "mentor");
    }

    @Test
    public void testGetName() {
        assertEquals("Mateusz", mentor.getName());
    }

}