package com.school.controllers;


import com.school.dao.*;
import com.school.models.Course;
import com.school.models.Student;
import com.school.models.User;
import com.school.models.Quest;
import com.school.views.MentorView;

import java.util.ArrayList;

public class MentorController {

    public static boolean startController(User mentor) {

        MentorDAO myMentor = new MentorDAO(mentor);

        MentorView.welcomeMsg(mentor.getName());
        MentorView.showMenu();

        String choice = MentorView.getChoice();
        startRequestProcess(choice);

        return true;
    }

    public static void startRequestProcess(String choice) {

        if(choice.equals("1")) {
            createNewStudentProcess();
        }

        if (choice.equals("2")) {
            showAvailableCourses();
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

    public static void createNewStudentProcess(){

        String name = MentorView.typeStudentName();
        String surname = MentorView.typeStudentSurname();
        String password = MentorView.typeStudentPassword();
        String mail = MentorView.typeStudentMail();
        String status = "student";

        showAvailableCourses();
        Integer id = MentorView.getCourseId();

        createNewStudentObject(name, surname, password, mail, status, id);
    }

    static void createNewStudentObject(String name, String surname, String password,
                                              String mail, String status, Integer id){

        Student student = new Student(name, surname, password, mail, status);
        CourseDAO courseDAO = new CourseDAO();
        assignStudentToCourse(student, courseDAO.getCourseById(id));

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
        MentorView.showAllStudents(studentsList);

    }

    public static void showAvailableCourses() {

        ArrayList<Course> courses = new CourseDAO().getAllCourses();
        MentorView.showAllCourses(courses);
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



