package src.dao;

import src.models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public abstract class AbstractDAO implements DAOInterface {

    private final String path;
    private User person;

    public AbstractDAO(User person, String path) {
        this.person = person;
        this.path = path;
    }

    @Override
    public User load(String id) {

        User user = null;

        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(new File(path))))){


            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String nLine[] = line.split(",");

                if (nLine[3].equals(id)) {
                    user = createFromRow(nLine);
                }
            }
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User createFromRow(String[] nLine) {

        User user = this.person;

        String name = nLine[0];
        String surname = nLine[1];
        String password = nLine[2];
        String id = nLine[3];
        String mail = nLine[4];

        user.setName(name);
        user.setId(id);
        user.setSurname(surname);
        user.setPassword(password);
        user.setMail(mail);

        return user;
    }

    @Override
    public void save(User user) {

        try(FileWriter fw = new FileWriter(path, true)){

            String line = String.format("\n%s,%s,%s,%s,%s", user.getName(), user.getSurname(),
                    user.getPassword(), user.getId(), user.getId());

            fw.append(line);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
