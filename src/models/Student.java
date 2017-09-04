package src.models;

import src.models.AbstractUser;

import java.util.ArrayList;

public class Student extends AbstractUser {

    Wallet wallet;
    //ArrayList<> studentQuests = new ArrayList<>();

    public Student(){}

    public Student(String name, String surname, String password, String login, String id){
        super(name, surname, password, login, id);
        this.wallet = new Wallet();
    }

}

