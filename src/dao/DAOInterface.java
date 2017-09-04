package src.dao;

import src.models.User;

import java.io.IOException;

public interface DAOInterface {

    Object load(String id);
    void save(User object) throws IOException;
    Object createFromRow(String[] line);
}
