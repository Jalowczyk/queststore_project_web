package com.school.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
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

    @Test
    public void testGetSurname() {
        assertEquals("Ostafil", mentor.getSurname());
    }

    @Test
    public void testGetPassword() {
        assertEquals("password", mentor.getPassword());
    }

    @Test
    public void testGetMail() {
        assertEquals("mat@gmail.com", mentor.getMail());
    }

    @Test
    public void testGetStatus() {
        assertEquals("mentor", mentor.getStatus());
    }

    @Test
    public void testGetId() {
        assertEquals(null, mentor.getId());
    }


    @Test
    public void testSetName() {
        mentor.setName("Jan");
        assertEquals("Jan", mentor.getName());
    }

    @Test
    public void testSetSurname() {
        mentor.setSurname("Nowak");
        assertEquals("Nowak", mentor.getSurname());
    }

    @Test
    public void testSetPassword() {
        mentor.setPassword("1234");
        assertEquals("1234", mentor.getPassword());
    }

    @Test
    public void testSetMail() {
        mentor.setMail("mentor@gmail.com");
        assertEquals("mentor@gmail.com", mentor.getMail());
    }

    @Test
    public void testSetStatus() {
        mentor.setStatus("student");
        assertEquals("student", mentor.getStatus());
    }

    @Test
    public void testSetId() {
        Integer id = 1;
        mentor.setId(id);
        assertEquals(id, mentor.getId());
    }


}