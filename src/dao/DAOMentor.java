package src.dao;

import src.models.Mentor;

public class DAOMentor extends AbstractDAO {

    private static final String dataBasePath = "jdbc:sqlite:src/sql/mentors.db";
    private static final String sqlName = "mentors";

    private static Mentor mentor = new Mentor();

    public DAOMentor() {
        super(sqlName, dataBasePath, mentor);
    }
}
