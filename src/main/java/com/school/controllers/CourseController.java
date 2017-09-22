package com.school.controllers;

import com.school.dao.CourseDAO;
import com.school.models.Course;

import java.util.ArrayList;

public class CourseController {

    public static void saveCourse(Course course) {

        CourseDAO newCourse = new CourseDAO();
        newCourse.saveCourse(course);
    }

    public static void listAllCourses() {
        String table = "courses";
        String status = "*";
        ArrayList<String> coursesList = new CourseDAO().listSpecifiedData(table, status);
        for (String course : coursesList) {
            System.out.println(course);
        }
    }
}
