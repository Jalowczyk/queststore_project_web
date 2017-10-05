package com.school.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private class AbstractUser extends User {
        private AbstractUser(String name, String surname, String password, String mail, String status) {
            super(name, surname, password, mail, status);
        }
    }

    AbstractUser user;

    @BeforeEach
    public void before() {
        this.user = new AbstractUser("name", "surname", "password", "mail", "status");
    }

    @Test
    void testGetStatus() {
    }

    @Test
    void testSetStatus() {
    }

    @Test
    void testToString() {
    }

    @Test
    void testSetName() {
    }

    @Test
    void testGetName() {
    }

    @Test
    void testGetSurname() {
    }

    @Test
    void testGetId() {
    }

    @Test
    void testSetSurname() {
    }

    @Test
    void testSetPassword() {
    }

    @Test
    void testGetPassword() {
    }

    @Test
    void testSetId() {
    }

    @Test
    void testSetMail() {
    }

    @Test
    void testGetMail() {
    }

}