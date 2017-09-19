package com.school.dao;

import com.school.models.Admin;

public class DAOAdmin extends AbstractDAO {

    private static final String sqlName = "admins";

    public DAOAdmin(Admin admin) {
        super(sqlName, admin);
    }
}