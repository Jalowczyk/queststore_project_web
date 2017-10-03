package com.school.models;

import com.school.controllers.AdminController;
import com.school.controllers.StudentController;

public class Student extends User {

    private Wallet wallet;
    private Course course;


    public Student(){
    }

    public Student(String name, String surname, String mail, String password, String status){
        super(name, surname, password, mail, status);

        this.wallet = new Wallet();
    }

    public void startController(){
        StudentController.startController(this);
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}