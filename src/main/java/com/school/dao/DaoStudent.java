package com.school.dao;
import com.school.models.Student;
import com.school.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoStudent extends UserDao {

    private Student student;

    public DaoStudent(Student student) {
        this.student = student;
    }


    public void save() {

        save(student);
        saveCourse();
    }

    public void saveCourse() {

        String query = "INSERT INTO students (student_id, course_id) VALUES(?,?)";

        try(PreparedStatement statement = conn.prepareStatement(query)){

            statement.setInt(1, UserDao.getLastId());
            statement.setInt(2, student.getCourse().getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

