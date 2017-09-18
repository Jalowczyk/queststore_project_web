package com.school.dao;

import com.school.models.User;

import java.io.IOException;

public interface DAOInterface {

    User load(String id);
    void save(User object) throws IOException;
    Object createFromRow(String name, String surname, String password, String id, String mail);
}
