package com.school.dao;

import com.school.models.User;

import java.io.IOException;

public interface DAOUserInterface {

    User load(String id);
    void save(User user);
    User createFromRow(Integer id, String... values);
}
