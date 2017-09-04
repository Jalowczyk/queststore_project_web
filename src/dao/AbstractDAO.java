package src.dao;

import src.models.Mentor;
import src.models.User;
import src.models.Admin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public abstract class AbstractDAO implements DaoInterface {

    private final String path;
    private User person;

    public AbstractDAO(User person, String path) {
        this.person = person;
        this.path = path;
    }

    @Override
    public User load(String id) {

        User user = null;

        try {

            File csvFile = new File(path);

            Scanner scanner = new Scanner(new BufferedReader(new FileReader(csvFile)));

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

        User user = checkWhoIsUser(person);

        String name = nLine[0];
        String surname = nLine[1];
        String password = nLine[2];
        String id = nLine[3];
        String mail = nLine[4];

        user.setName(name);
        user.setLogin(id);
        user.setSurname(surname);
        user.setPassword(password);
        user.setMail(mail);

        return user;
    }

    public User checkWhoIsUser(User person) {

        User user = null;

        if (person instanceof Admin) {
            user = new Admin();

        }if (person instanceof Mentor) {
            user = new Mentor();
        }
        return user;
    }

    @Override
    public void save(User user) {

        try {
            FileWriter fw = new FileWriter(path, true);

            String line = String.format("\n%s,%s,%s,%s,%s", user.getName(), user.getSurname(),
                    user.getPassword(), user.getLogin(), user.getLogin());

            fw.append(line);
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}