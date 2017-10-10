package com.school.models;


public class Student extends User {

    private Wallet wallet;
    private Course course;
    private static String status = "student";


    public Student(){
    }

<<<<<<< HEAD
    public Student(String name, String surname, String mail, String password){

=======
    public Student(String name, String surname, String password, String mail, String status){
>>>>>>> 04e73a720d7d490e7df800e03ae3d218756258bf
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