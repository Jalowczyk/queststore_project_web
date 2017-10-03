package com.school.controllers;

import com.school.dao.MentorDAO;
import com.school.dao.UserDAO;
import com.school.models.Mentor;
import com.school.models.User;
import com.school.views.AdminView;
import com.school.views.MentorView;

import java.util.ArrayList;

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

        } else if(choice.equals("2")){
            createCourse();

        } else if(choice.equals("3")){
            editMentorProfile();

        } else if(choice.equals("4")){
            showCourseInfo();

        } else if(choice.equals("5")){
            showMentorProfile();

        } else if(choice.equals("0")){
            System.exit(0);
        }


    }

    public static Mentor createMentor(){


        String name = AdminView.typeMentorName();
        String surname = AdminView.typeMentorSurname();
        String password = AdminView.typeMentorPassword();
        String mail = AdminView.typeMentorEmail();
        String status = "mentor";

        Mentor mentor = new Mentor(name, surname, password, mail, status);

        saveMentor(mentor);

        return mentor;

    }

    public static void saveMentor(Mentor mentor){

        MentorDAO myMentor = new MentorDAO(mentor);
        myMentor.save();
    }

    public static void createCourse(){

        System.out.println("To be implemented");
    }

    public static void editMentorProfile(){

        Integer id = MentorView.getMentorId();
        String name = MentorView.typeStudentName();

        MentorDAO.editMentor(name, id);
        System.out.println("details have changed");
    }

    public static void showCourseInfo(){

        System.out.println("To be implemented");
    }

    public static void showMentorProfile(){

        ArrayList<User> mentorsList = new UserDAO().getAllUsersByStatus("mentor");

        for(User mentor : mentorsList){
            MentorView.showStudent(mentor);
        }
        Integer id = AdminView.typeMentorId();
        User user = new UserDAO().getUserById(id);

        MentorView.showStudent(user);
        }
    }

