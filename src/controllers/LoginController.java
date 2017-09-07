package src.controllers;

import src.controllers.AdminController;
import src.controllers.MentorController;
import src.models.User;
import src.views.LoginView;
import src.dao.DAOAdmin;
import src.dao.DAOMentor;
// import src.dao.DAOStudent;

public class LoginController {

    public static void roleSetting() {

        LoginView.setUserLoginMsg();
        String choice = LoginView.getUserChoiceInput();

        LoginView.setUserId();
        String id = LoginView.getInput();

        startLoginProcess(choice, id);
    }

    public static void startLoginProcess(String choice, String id) {

        if (choice.equals("1")) {
            adminLoginProcess(id);

        } else if (choice.equals("2")) {
            mentorLoginProcess(id);

        // } else if (choice.equals("3")) {
        //     studentLoginProcess(id);
        }
    }

    public static User getAdmin(String id) {
        DAOAdmin admin = new DAOAdmin();
        User loadedAdmin = admin.load(id);
        return loadedAdmin;
    }

    public static User getMentor(String id) {
        DAOMentor mentor = new DAOMentor();
        User loadedMentor = mentor.load(id);
        return loadedMentor;
    }

    // public static User getStudent(String id) {
    //     DAOStudent student = new DAOStudent();
    //     User loadedStudent = student.load(id);
    //     return loadedStudent;
    // }

    public static void adminLoginProcess(String id) {

        User user = getAdmin(id);

        if (user != null) {

            AdminController.startController(user);
        } else {
            LoginView.failedLoginMsg();
        }
    }
        
    public static void mentorLoginProcess(String id) {

        User user = getMentor(id);

        if (user != null) {

            MentorController.startController(user);

        } else {
            LoginView.failedLoginMsg();
        }
    }

    // public static void studentLoginProcess(String id) {

    //     User user = getStudent(id);

    //     if (user != null) {

    //         StudentController.startController(user);

    //     } else {
    //         LoginView.failedLoginMsg();
    //     }
    // }
}
