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

        ArrayList<Course> courses = new CourseDAO().getAllCourses();
        for (Course course : courses) {
            System.out.println(course);
        }
    }
}
