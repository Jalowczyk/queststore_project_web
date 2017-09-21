package com.school.views;

import java.util.Scanner;

public class MentorView extends AbstractView{

    private static Scanner scan = new Scanner(System.in);
    private static int inputNum; 
    
    public static String getChoice() {
        Scanner scanForNumbers = new Scanner(System.in);
        do {
            System.out.println("Please choose an option: ");
            inputNum = scanForNumbers.nextInt();
        } while (inputNum <0 | inputNum >7);

        return Integer.toString(inputNum);
    }

    public static void showMenu() {
        String menu = "\n1. Create student"
                        + "\n2. Show info about chosen Course"
                        + "\n3. Manage Quests"
                        + "\n4. Manage Artefacts"
                        + "\n5. Show info about all Students"
                        + "\n6. Mark Student's Artefacts"
                        + "\n6. Mark Student's Quests"
                        + "\n0. Exit";
                        
        System.out.println(menu);    
    }

    public static String typeStudentName() {

        System.out.println("\nPlease provide the student's name: ");
        String name = scan.nextLine();
        return name;
    }

    public static String typeStudentSurname(){

        System.out.println("Please provide the student's surname: ");
        String surname = scan.nextLine();
        return surname;
    }

    public static String typeStudentPassword() {

        System.out.println("Please provide the password for student: ");
        String password = scan.nextLine();
        return password;
    }

    public static String typeStudentMail(){
        System.out.println("Please provide the student's mail: ");
        String mail = scan.nextLine();
        return mail;
    }

    public static Integer getMentorId(){
        System.out.println("Please provide mentor's id: ");
        Integer id = scan.nextInt();
        return id;
    }


}   
