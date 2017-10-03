package com.school.views;

import java.util.Scanner;

public class AdminView extends AbstractView{

    private static Scanner scan = new Scanner(System.in);
    private static int inputNum; 
    
    public static String getChoice() {
        Scanner scanForNumbers = new Scanner(System.in);
        do {
            System.out.println("Please choose an option: ");
            inputNum = scanForNumbers.nextInt();
        } while (inputNum <0 | inputNum >6);

        return Integer.toString(inputNum);
    }

    public static void showMenu() {
        String menu = "\n1. Create mentor"
                        + "\n2. Create new Course"
                        + "\n3. Edit chosen Mentor profile"
                        + "\n4. Show info about chosen Course"
                        + "\n5. Show info about chosen Mentor"
                        + "\n6. Set level of Experience"
                        + "\n0. Exit";
                        
        System.out.println(menu);
    }

    public static String typeMentorName() {

        System.out.println("\nPlease provide the name of mentor: ");
        String name = scan.nextLine();
        return name;
    }

    public static String typeMentorSurname(){

        System.out.println("Please provide the surname of mentor: ");
        String surname = scan.nextLine();
        return surname;
    }

    public static String typeMentorPassword() {

        System.out.println("Please provide the password for mentor: ");
        String password = scan.nextLine();
        return password;
    }

    public static Integer typeMentorId() {

        System.out.println("Please provide the id for mentor: ");
        Integer id = scan.nextInt();
        return id;
    }

    public static String typeMentorEmail(){

        System.out.println("Please provide the mail of mentor: ");
        String email = scan.nextLine();
        return email;
    }


}   
