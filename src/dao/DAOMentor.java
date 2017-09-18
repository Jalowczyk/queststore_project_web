package src.dao;

import src.models.Mentor;

public class DAOMentor extends AbstractDAO {

    private static final String sqlName = "mentors";

    public DAOMentor(Mentor mentor) {
        super(sqlName, mentor);
    }

    
}