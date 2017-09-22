package com.school.controllers;

import com.school.models.Student;
import com.school.models.User;
import com.school.views.StudentView;

public class StudentController {

    public static void startController(Student student) {

        StudentView.welcomeMsg(student.getName());
        StudentView.showMenu();

        String choice = StudentView.getChoice();
        startRequestProcess(choice, student);
    }

    public static void startRequestProcess(String choice, Student student) {

        if(choice.equals("1")){
            showWalletInfo(student);

        } else if(choice.equals("2")){
            goToStore(); //start Shop controller

        } else if(choice.equals("3")){
            seeMyLevel(student);

        } else if(choice.equals("0")){
            System.exit(0);
        }
    }

    public static void showWalletInfo(Student student) {

        Integer balance = student.getWallet().getBalance();

        StudentView.showWalletInfo(balance);
    }

    public static void seeMyLevel(Student student) {

        Integer experience = student.getWallet().getExperience();

        StudentView.showMyLevel(experience);
    }

    public static void goToStore() {

        System.out.println("To be implemented.");
    }

}