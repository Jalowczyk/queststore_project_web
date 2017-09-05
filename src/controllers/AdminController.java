package src.controllers;

import src.models.Mentor;
import src.dao.DAOMentor;
import src.models.User;
import src.views.AdminView;

public class AdminController {

    public static void startController(User admin) {

        AdminView.welcomeMsg(admin.getName());
        AdminView.showMenu();

        String choice = AdminView.getChoice();
        startRequestProcess(choice);

    }

    public static void startRequestProcess(String choice){

        if(choice.equals("1")){
            createMentor();

        }if(choice.equals("2")){

        }
    }
    
    public static Mentor createMentor(){

        String name = AdminView.typeMentorName();
        String surname = AdminView.typeMentorSurname();
        String password = AdminView.typeMentorPassword();
        String id = AdminView.typeMentorId();
        String mail = AdminView.typeMentorMail();

        Mentor mentor = new Mentor(name, surname, password, id, mail);

        saveMentor(mentor);

        return mentor;

    }

    public static void saveMentor(Mentor mentor){

        DAOMentor DaoMentor = new DAOMentor();
        DaoMentor.save(mentor);
    }

}
