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

    }

    public void saveStudentRecords() {

        String query = "INSERT INTO students (student_id, course_id, wallet_id) VALUES(?,?,?)";

        try(PreparedStatement statement = conn.prepareStatement(query)){

            statement.setInt(1, UserDAO.getLastUserCreatedId());
            statement.setInt(2, student.getCourse().getId());
            statement.setInt(3, WalletDAO.getLastWalletCreatedId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

