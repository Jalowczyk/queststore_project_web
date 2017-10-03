package com.school.controllers;


import com.school.dao.*;
import com.school.models.Course;
import com.school.models.Student;
import com.school.models.User;
import com.school.models.Quest;
import com.school.views.MentorView;

import java.util.ArrayList;

public class MentorController {

    public static void startController(User mentor) {

        MentorDAO myMentor = new MentorDAO(mentor);
        //myMentor.loadAllAttributes();

        MentorView.welcomeMsg(mentor.getName());
        MentorView.showMenu();

        String choice = MentorView.getChoice();
        startRequestProcess(choice);
    }

    public static void startRequestProcess(String choice) {

        if (choice.equals("1")) {

            getNewStudentInfo();
        }

        if (choice.equals("2")) {
            showCourseInfo();
        }
        if (choice.equals("3")) {
            manageQuests(); //start QuestController

        }
        if (choice.equals("4")) {
            manageArtefacts(); //start ArtefactController

        }
        if (choice.equals("5")) {
            showStudentInfo(); //summary of student wallet, bought artefacts

        }
        if (choice.equals("6")) {
            markStudentArtefacts();
        }
        if (choice.equals("7")) {
            markStudentQuest();
        }
        if (choice.equals("8")) {
            System.out.println("sads");
            setLvlExperience();
        }
        if (choice.equals("0")) {
            System.exit(0);
        }
    }

    public static void getNewStudentInfo() {

        String name = MentorView.typeStudentName();
        String surname = MentorView.typeStudentSurname();
        String password = MentorView.typeStudentPassword();
        String mail = MentorView.typeStudentMail();
        String status = "student";

        CourseController.listAllCourses();
        Integer id = MentorView.getCourseId();

        createNewStudent(name, surname, password, mail, status, id);
    }

    public static void createNewStudent(String name, String surname, String password,
                                        String mail, String status, Integer id) {

        Student student = new Student(name, surname, password, mail, status);
        assignStudentToCourse(student, CourseDAO.createCourseFromDatabase(id));

        saveStudent(student);
    }

    public static void assignStudentToCourse(Student student, Course course) {

        student.setCourse(course);
    }

    private static void saveStudent(Student student) {

        StudentDAO myStudent = new StudentDAO(student);
        WalletDAO myWallet = new WalletDAO();

        myWallet.saveWallet(student.getWallet());
        myStudent.save();
    }

    public static void showStudentInfo() {

        String status = "student";
        ArrayList<User> studentsList = new UserDAO().getAllUsersByStatus(status);
        for (User student : studentsList) {
            System.out.println(student);
        }

    }

    public static void showCourseInfo() {

        CourseController.listAllCourses();
    }

    public static void manageQuests() {

        String title = MentorView.getQuestTitle();
        String info = MentorView.getQuestInfo();
        Integer prize = MentorView.getQuestPrize();
        String category = MentorView.getQuestCategory();

        Quest quest = new Quest(title, info, prize, category);
        QuestDAO questDAO = new QuestDAO();

        questDAO.saveQuest(quest);
    }

    public static void manageArtefacts() {

        System.out.println("To be implemented");
    }

    public static void markStudentArtefacts() {

        System.out.println("To be implemented");
    }

    public static void markStudentQuest() {

        System.out.println("To be implemented");
    }

    public static void setLvlExperience() {

        UserDAO dao = new UserDAO();
        ArrayList<User> students = dao.getAllUsersByStatus("student");
        Integer id;

        for (User student : students) {
            System.out.println(student.getName());
            System.out.println(student.getId());
        }
           id = MentorView.typeUserId();

           User user = dao.getUserById(id);

        }
    }



