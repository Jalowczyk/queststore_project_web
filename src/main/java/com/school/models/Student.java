package com.school.models;

import com.school.controllers.AdminController;
import com.school.controllers.StudentController;

public class Student extends User {

    private Wallet wallet;
    //ArrayList<> studentQuests = new ArrayList<>();

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Student(){


    }

//    public Student(String name, String surname, String password, String login, String id){
//        super(name, surname, password, login, id);
//        this.wallet = new Wallet();
//    }

    public void startController(){
        StudentController.startController(this);

    }



}

