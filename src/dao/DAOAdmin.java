package src.dao;

import src.models.Admin;

public class DAOAdmin extends AbstractDAO {

    private static final String dataBasePath = "jdbc:sqlite:src/sql/admins.db";
    private static final String sqlName = "admins";

    public DAOAdmin(Admin admin) {
        super(sqlName, dataBasePath, admin);
    }
}