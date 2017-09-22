package com.school.dao;

import com.school.models.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CourseDAO {


    public ArrayList<String> listSpecifiedData(String table, String status) {
        ArrayList<String> foundData = new ArrayList<>();

        String query = "SELECT * FROM " + table + " WHERE id = '" + status + "' ";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                String recordFound;
                recordFound = String.format("ID: %s - %s",
                        rs.getString("id"),
                        rs.getString("course_name"));

                foundData.add(recordFound);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return foundData;
    }

    public Course createCourse(ResultSet rs) throws SQLException {

        String name = rs.getString("name");

        return new Course(name);

    }

    public void saveCourse(Course course) {

        String query = "INSERT INTO course (course_name) VALUES(?)";

        try (PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, course.getName());


            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

