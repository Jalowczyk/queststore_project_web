package com.school.models;


import java.util.ArrayList;

public class Student extends User {

    private Wallet wallet;
    private Course course;
    private static String status = "student";
    private ArrayList<Artifact> artifacts;

    public ArrayList<Artifact> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(ArrayList<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

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