package com.school.models;

import com.school.controllers.AdminController;
import com.school.controllers.MentorController;
import com.school.controllers.StudentController;

public class UserLogger {

    public static void logIn(User user) {

        if (user.getStatus().equals("student")) {

            Student student = (Student) user;
            StudentController.startController(student);
        }
        if (user.getStatus().equals("mentor")) {

            Mentor mentor = (Mentor) user;
            MentorController.startController(mentor);
        }
        if (user.getStatus().equals("admin")) {

            Admin admin = (Admin) user;
            AdminController.startController(admin);

        }
    }
}
