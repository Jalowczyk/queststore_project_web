package com.school.models;

import com.school.controllers.AdminController;


public class Admin extends User {

    public Admin(){}

    public Admin(String name, String surname, String password, String mail, String status) {
        super(name, surname, password, mail, status);
    }

    @Override
    public void startController(){
        AdminController.startController(this);
    }
}

