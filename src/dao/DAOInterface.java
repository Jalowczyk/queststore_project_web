package src.dao;

import src.models.User;

import java.io.IOException;

public interface DAOInterface {

    Object load(String id);
    void save(User object) throws IOException;
    Object createFromRow(String name, String surname, String password, String id, String mail);
}
