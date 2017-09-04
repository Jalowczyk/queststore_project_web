package src.dao;

import src.models.Admin;

public interface adminDaoInterface {

    public Object load(String id);
    public void save(Admin object);
    public Object createFromRow(String[] line);

    }
