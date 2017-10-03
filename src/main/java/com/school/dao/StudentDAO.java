package com.school.dao;
import com.school.models.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO extends UserDAO {

    private Student student;

    public StudentDAO(Student student) {
        this.student = student;
    }

    public void save() {

        saveUser(student);
        saveStudentRecords();
    }

    public void saveStudentRecords() {

        String query = "INSERT INTO students (student_id, course_id, wallet_id) VALUES(?,?,?)";

        try (PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, UserDAO.getLastUserCreatedId());
            statement.setInt(2, student.getCourse().getId());
            statement.setInt(3, WalletDAO.getLastWalletCreatedId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getStudentWalletId() {

        Integer studentWalletId = null;
        String query = "SELECT wallet_id FROM students WHERE student_id = " + student.getId() + ";";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {

                studentWalletId = rs.getInt("wallet_id");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentWalletId;
    }

    public Integer getStudentCourseId() {

        Integer studentCourseId = null;
        String query = "SELECT course_id FROM students WHERE student_id = " + student.getId() + ";";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {

                studentCourseId = rs.getInt("course_id");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentCourseId;
    }
}


