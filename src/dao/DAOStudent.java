package  src.dao;

import java.io.*;
import java.util.Scanner;

import src.models.Student;

public class DAOStudent implements StudentDAO {

    private static final String FILE_NAME = "Students.csv";

    public DAOStudent() {
    }

    @Override
    public Student load(String id){

        try {

            File csvFile = new File("/Users/valik/Desktop/queststore-system-team_power/src/csv/Admins.csv");
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(csvFile)));

            while(scanner.hasNextLine()){

                String line = scanner.nextLine();
                String nLine [] = line.split(",");
                if(nLine[4].equals(id)) {
                    Student student = createFromRow(nLine);
//                    return mentor;
                }
            }
            scanner.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
        return new Student();
    }

    @Override
    public void save(Student student) {

        try {
            FileWriter fw = new FileWriter(getClass().getClassLoader().getResource(FILE_NAME).getFile(),true);

            String line = String.format("\n%s,%s,%s,%s,%s", student.getName(),student.getSurname(),student.getLogin(), student.getLogin());

            fw.append(line);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    @Override
    public Student createFromRow(String[] nLine){

        Student s = new Student();

        String name = nLine[0];
        String surname = nLine[1];
        String login = nLine[3];
        String id = nLine[4];


//
//        s.setName(name);
//        s.setId(id);
//        s.setSurname(surname);
//        s.setLogin(login);

        return s;
    }
}
