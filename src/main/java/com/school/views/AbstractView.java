package com.school.views;

public abstract class AbstractView {

    public static void welcomeMsg(String name){
        String message = String.format(("Welcome %s!"),name);
        System.out.println(message);
    }
}
