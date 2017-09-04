package src.dao;

import src.models.Admin;

import java.io.*;
import java.util.Scanner;



public class DAOAdmin implements AdminDAO {

    private static final String FILE_NAME = "Admins.csv";

    public DAOAdmin() {
    }

    @Override
    public Admin load(String id){
    
        Admin admin = null;

        try {
            File csvFile = new File("/Users/valik/Desktop/queststore-system-team_power/src/csv/Admins.csv");
             
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(csvFile)));
        
            while(scanner.hasNextLine()){

                String line = scanner.nextLine();
                String nLine [] = line.split(",");

                if(nLine[3].equals(id)) {
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
            FileWriter fw = new FileWriter("/Users/valik/Desktop/queststore-system-team_power/src/csv/Admins.csv",true);


            String line = String.format("\n%s,%s,%s,%s", admin.getName(),admin.getSurname(),
                                                            admin.getLogin(), admin.getMail());


            fw.append(line);
            


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
        String id = nLine[3];
        String mail = nLine[4];

        a.setName(name);
        a.setLogin(id);
        a.setSurname(surname);
        a.setPassword(password);
        a.setMail(mail);

        return a;
    }
}
