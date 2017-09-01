package src.dao;

import src.models.Mentor;

public interface MentorDAO {

    public Object load(String id);
    public void save(Mentor object);
    public Object createFromRow(String[] line);

    }
