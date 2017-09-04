package src.controllers;

import src.models.Admin;
import src.models.Mentor;
import src.dao.DAOMentor;
import src.models.User;

public class AdminController {


    public static void startController(User admin) {
        System.out.println(admin.getName());
        Mentor mentor = createMentor("Masha", "Bes", "1122", "mabes", "www.mail.com");
    }

    public static Mentor createMentor(String name, String surname, String password, String login, String mail) {

        Mentor mentor = new Mentor(name, surname, password, login, mail);
        DAOMentor DaoMentor = new DAOMentor();
        DaoMentor.save(mentor);
        return mentor;

    }
}