package src.dao;

import src.models.Mentor;
import java.io.*;
import java.util.Scanner;



public class DAOMentor implements mentorDaoInterface {

    private static final File f = new File("src/csv/Mentors.csv");
    private static final String path = f.getAbsolutePath();

    public DAOMentor() {
    }

    @Override
    public Mentor load(String id){

        try {

            File csvFile = new File(path);
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(csvFile)));

            while(scanner.hasNextLine()){

                String line = scanner.nextLine();
                String nLine [] = line.split(",");
                if(nLine[4].equals(id)) {
                    Mentor mentor = createFromRow(nLine);
                    return mentor;
                }
            }
            scanner.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
        return new Mentor();
    }

    @Override
    public void save(Mentor mentor) {

        try {
            FileWriter fw = new FileWriter(path, true);
            String line = String.format("%s,%s,%s,%s,%s\n", mentor.getName(),mentor.getSurname(), mentor.getPassword(),
                                                             mentor.getLogin(), mentor.getMail());

            fw.append(line);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    @Override
    public Mentor createFromRow(String[] nLine){

        Mentor mentor = new Mentor();

        String name = nLine[0];
        String surname = nLine[1];
        String password = nLine[2];
        String id = nLine[3];
        String mail = nLine[4];

        mentor.setName(name);
        mentor.setLogin(id);
        mentor.setSurname(surname);
        mentor.setPassword(password);
        mentor.setMail(mail);

        return mentor;
    }
}
