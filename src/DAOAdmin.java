import java.io.*;
import java.util.Scanner;



public class DAOAdmin implements AdminDAO {

    private static final String FILE_NAME = "Admins.csv";

    public DAOAdmin() {
    }
d
    @Override
    public Admin load(String id){

        Admin admin = null;

        try {

            File csvFile = new File(getClass().getClassLoader().getResource(FILE_NAME).getFile());
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(csvFile)));

            while(scanner.hasNextLine()){

                String line = scanner.nextLine();
                String nLine [] = line.split(",");
                if(nLine[4].equals(id)) {
                    admin = createFromRow(nLine);
                }           
            }
            scanner.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public void save(Admin admin) {

        try {
            FileWriter fw = new FileWriter(getClass().getClassLoader().getResource(FILE_NAME).getFile(),true);

            String line = String.format("\n%s,%s,%s,%s,%s", admin.getName(),admin.getSurname(),
                                                admin.getLogin(), admin.getId(), admin.getMail());

            fw.append(line);
            

        } catch (IOException e) {
            e.printStackTrace();

        } finally{
            fw.close();
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
