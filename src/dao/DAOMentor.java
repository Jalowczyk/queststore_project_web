package src.dao;

import src.models.Mentor;

import java.io.*;


public class DAOMentor extends AbstractDAO {

    private static final File f = new File("src/csv/Mentors.csv");
    private static final String path = f.getAbsolutePath();
    private static Mentor mentor = new Mentor();

    public DAOMentor() {
        super(mentor, path);
    }
}
