package com.school.dao;

import com.school.models.User;

import java.io.IOException;

public interface DAOInterface {

    User load(String id);
    User createFromRow(Integer id, String... values);
}
