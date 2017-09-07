package src.controllers;

import src.models.User;
import src.models.Mentor;
import src.views.ApplicationView;
import src.dao.DAOAdmin;
import src.dao.DAOMentor;
import src.models.Admin;

public class LoginController {

    public static void roleSetting() {

        ApplicationView.setUserLoginMsg();
        String choice = ApplicationView.getUserChoiceInput();

        ApplicationView.setUserId();
        String id = ApplicationView.getInput();

        startLoginProcess(choice, id);
    }

    public static void startLoginProcess(String choice, String id) {

        if (choice.equals("1")) {
            adminLoginProcess(id);

        } else if (choice.equals("2")) {
            mentorLoginProcess(id);
        }
    }

    public static User getAdmin(String id) {
        DAOAdmin admin = new DAOAdmin(new Admin());
        User createdAdmin = admin.load(id);
        return createdAdmin;
    }

    public static User getMentor(String id) {
        DAOMentor mentor = new DAOMentor(new Mentor());
        User createdMentor = mentor.load(id);
        return createdMentor;
    }

    public static void adminLoginProcess(String id) {

        User user = getAdmin(id);

        if (user != null) {

            AdminController.startController(user);
        } else {
            ApplicationView.failedLoginMsg();
        }
    }
        
    public static void mentorLoginProcess(String id) {

        User user = getMentor(id);

        if (user != null) {

            MentorController.startController(user);

        } else {
            ApplicationView.failedLoginMsg();
        }
    }
}
