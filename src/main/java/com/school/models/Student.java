package com.school.models;

import com.school.controllers.AdminController;
import com.school.controllers.StudentController;

public class Student extends User {

    private Wallet wallet;

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Student(){


    }

    public Student(String name, String surname, String password, String mail, String status){
        super(name, surname, password, mail, status);
    }


}

