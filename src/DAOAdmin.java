import java.io.*;
import java.util.Scanner;



public class DAOAdmin implements AdminDAO {

    private static final String FILE_NAME = "Admins.csv";

    public DAOAdmin() {
    }

    @Override
    public Admin load(String id){

        try {

            File csvFile = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(csvFile)));

            while(scanner.hasNextLine()){

                String line = scanner.nextLine();
                String nLine [] = line.split(",");
                if(nLine[4].equals(id)) {
                    Admin admin = createFromRow(nLine);
                    return admin;
                }
            }
            scanner.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
        return new Admin();
    }

    @Override
    public void save(Admin admin) {

        try {
            FileWriter fw = new FileWriter(getClass().getClassLoader().getResource(FILE_NAME).getFile(),true);

            String line = String.format("\n%s,%s,%s,%s,%s", admin.getName(),admin.getSurname(),admin.getLogin(), admin.getId(), admin.getMail());

            fw.append(line);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    @Override
    public Admin createFromRow(String[] nLine){

        Admin a = new Admin();

        String name = nLine[0];
        String surname = nLine[1];
        String password = nLine[2];
        String login = nLine[3];
        String id = nLine[4];
        String mail = nLine[5];



        a.setName(name);
        a.setId(id);
        a.setSurname(surname);
        a.setPassword(password);
        a.setLogin(login);
        a.setMail(mail);

        return a;
    }
}
