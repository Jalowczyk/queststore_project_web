package src.dao;

import src.models.Student;

public interface StudentDAO {

    public Object load(String id);
    public void save(Student object);
    public Object createFromRow(String[] line);

    }
