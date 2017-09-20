package com.school.models;

import com.school.controllers.AdminController;

public class Admin extends User {


    public Admin() {
    }



        @Override
        public void startController(){
           AdminController.startController(this);
        }
//
//    public Admin(String name, String surname, String password, String id, String id, String mail){
//        super(name, surname, id, id, mail);
//    }

}

