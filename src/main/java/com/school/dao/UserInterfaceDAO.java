package com.school.dao;

import com.school.models.User;

import java.io.IOException;

public interface UserInterfaceDAO {

    User load(String id, String password);
    void save(User user);
    User createFromRow(Integer id, String... values);

}
