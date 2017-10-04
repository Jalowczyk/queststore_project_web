package com.school.models;

import org.junit.jupiter.api.BeforeEach;

class MentorTest {

    private Mentor mentor;

    @BeforeEach
    public void before() {
        this.mentor = new Mentor("Mateusz", "Ostafil", "password", "mat@gmail.com", "mentor");
    }

}