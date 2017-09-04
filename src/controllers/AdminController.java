package src.controllers;

import src.models.Admin;
import src.models.Mentor;
import src.dao.DAOMentor;

public class AdminController {


    public static void startController(Admin admin){
        System.out.println(admin.getName());
        Mentor mentor = createMentor("Igor","Bes","1122","igbes","www.mail.com");
    }
    
    public static Mentor createMentor(String name, String surname, String password, String login, String mail) {
        Mentor mentor = new Mentor(name, surname, password, login, mail);
        DAOMentor DaoMentor = new DAOMentor();
        DaoMentor.save(mentor);
        return mentor;

    }

}

