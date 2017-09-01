package src.dao;

public interface StudentDAO {

    public Object load(String id);
    public void save(Student object);
    public Object createFromRow(String[] line);

    }
