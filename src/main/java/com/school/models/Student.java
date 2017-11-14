package com.school.models;


public class Student extends User {

    private Wallet wallet;
    private Course course;
    private static String status = "student";


    public Student(){
    }


    public Student(String name, String surname, String mail, String password){

        super(name, surname, password, mail, status);
        this.wallet = new Wallet();

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