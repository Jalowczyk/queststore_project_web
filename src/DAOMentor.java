import java.io.*;
import java.util.Scanner;



public class DAOMentor implements MentorDAO {

    private static final String FILE_NAME = "Mentors.csv";

    public DAOMentor() {
    }

    @Override
    public Mentor load(String id){

        try {

            File csvFile = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
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
            FileWriter fw = new FileWriter(getClass().getClassLoader().getResource(FILE_NAME).getFile(),true);

            String line = String.format("\n%s,%s,%s,%s,%s", mentor.getName(),mentor.getSurname(),mentor.getLogin(), mentor.getId(), mentor.getMail());

            fw.append(line);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    @Override
    public Mentor createFromRow(String[] nLine){

        Mentor m = new Mentor();

        String name = nLine[0];
        String surname = nLine[1];
        String login = nLine[3];
        String id = nLine[4];
        Wallet wallet = nLine[5];



        m.setName(name);
        m.setId(id);
        m.setSurname(surname);
        m.setPassword(password);
        m.setLogin(login);
        m.setMail(mail);

        return m;
    }
}
