package src.dao;

import src.models.Admin;

import java.io.*;

public class DAOAdmin extends AbstractDAO {

    private static final File f = new File("src/csv/Admins.csv");
    private static final String path = f.getAbsolutePath();
    private static Admin admin = new Admin();

    public DAOAdmin() {
        super(admin, path);
    }
}