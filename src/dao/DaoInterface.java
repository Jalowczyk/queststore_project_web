package src.dao;

import src.models.User;

public interface DaoInterface {

    public Object load(String id);
    public void save(User object);
    public Object createFromRow(String[] line);
}
