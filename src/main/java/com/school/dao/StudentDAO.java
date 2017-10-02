package com.school.dao;
import com.school.models.Student;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO extends UserDAO {

    private Student student;

    public StudentDAO(Student student) {
        this.student = student;
    }


    public void save() {

        save(student);
        saveCourse();
    }

    public void saveCourse() {

        String query = "INSERT INTO students (student_id, course_id) VALUES(?,?)";

        try(PreparedStatement statement = conn.prepareStatement(query)){

            statement.setInt(1, UserDAO.getLastCreatedId());
            statement.setInt(2, student.getCourse().getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllStudents
}

