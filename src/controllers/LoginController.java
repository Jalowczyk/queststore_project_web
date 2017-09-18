package com.school.controllers;

import com.school.models.User;

import com.school.models.Mentor;
import com.school.dao.DAOAdmin;
import com.school.dao.DAOMentor;
import com.school.models.Admin;
import com.school.views.LoginView;


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

        DAOAdmin admin = new DAOAdmin(new Admin());
        User loadedAdmin = admin.load(id);
        return loadedAdmin;
    }

    public static User getMentor(String id) {
        DAOMentor mentor = new DAOMentor(new Mentor());
        User loadedMentor = mentor.load(id);
        return loadedMentor;
    }

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
