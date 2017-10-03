package com.school.models;

import com.school.controllers.MentorController;

public class Mentor extends User {

    public Mentor(){}

    public Mentor(String name, String surname, String password, String mail, String status) {
        super(name, surname, password, mail, status);
    }

    @Override
    boolean hasStudentRole() {return false;}

    @Override
    public void startController(){
        MentorController.startController(this);
    }

}
