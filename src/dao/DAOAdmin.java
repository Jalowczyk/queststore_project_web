package src.dao;

import src.models.Admin;

public class DAOAdmin extends AbstractDAO {

    private static final String dataBasePath = "jdbc:sqlite:src/sql/admins.db";
    private static final String dataBaseNameToSave = "INSERT INTO `admins`(name,surname,password,login,mail)";
    private static Admin admin = new Admin();

    public DAOAdmin() {
        super(dataBaseNameToSave, dataBasePath, admin);
    }
}