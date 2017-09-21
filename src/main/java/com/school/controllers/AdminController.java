package com.school.controllers;

import com.school.dao.DaoMentor;
import com.school.dao.UserDao;
import com.school.models.Mentor;
import com.school.models.User;
import com.school.views.AdminView;

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

        } else if(choice.equals("6")){
            setLvlExperience();

        } else if(choice.equals("0")){
            System.exit(0);
        }


    }

    public static Mentor createMentor(){


        String name = AdminView.typeMentorName();
        String surname = AdminView.typeMentorSurname();
        String password = AdminView.typeMentorPassword();
        String mail = AdminView.typeMentorMail();
        String status = "mentor";

        Mentor mentor = new Mentor(name, surname, password, mail, status);

        saveMentor(mentor);

        return mentor;

    }

    public static void saveMentor(Mentor mentor){

        DaoMentor myMentor = new DaoMentor(mentor);
        myMentor.save();
    }

    public static void createCourse(){

        System.out.println("To be implemented");
    }

    public static void editMentorProfile(){

        System.out.println("To be implemented");
    }

    public static void showCourseInfo(){

        System.out.println("To be implemented");
    }

    public static void showMentorProfile(){

        String status = "mentor";
        ArrayList<String> mentorsList = new UserDao().getAllMentors(status);
        for(String mentor : mentorsList){
            System.out.println(mentor);
        }
        String mentor = AdminView.chooseMentor();
        ArrayList<String> mentorList = new UserDao().getMentorDetails(mentor);
        for(String mentor1 : mentorList){
            System.out.println(mentor1);
        }
    }

    public static void setLvlExperience(){

        System.out.println("To be implemented");
    }


}
