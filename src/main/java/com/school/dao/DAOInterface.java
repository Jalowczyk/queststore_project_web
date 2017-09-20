package com.school.dao;

import com.school.models.User;

import java.io.IOException;

public interface DAOInterface {

    User load(String id);
    void save(User user) throws IOException;
    User createFromRow(String status, String name, String surname, String password, Integer id, String mail);
}
