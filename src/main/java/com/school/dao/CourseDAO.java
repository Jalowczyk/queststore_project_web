package com.school.dao;

import com.school.models.Course;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CourseDAO extends AbstractDao  {

    private static final String tableName = "courses";

    public CourseDAO() {

        super(tableName);
    }

    public ArrayList<String> listSpecifiedData() {

        String recordFound;
        ArrayList<String> foundData = new ArrayList<>();

        String query = "SELECT * FROM " + tableName + ";";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                recordFound = String.format("ID: %d - '%s'",
                              rs.getInt("crs_id"),
                              rs.getString("course_name"));

                foundData.add(recordFound);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return foundData;
    }

    public static Course createCourseFromDatabase(Integer id) {

        Course course = null;

        String query = "SELECT * FROM courses WHERE crs_id = " + id + ";";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

             if(rs.next()){
                 course = createCourseFromResultSet(rs);
             }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }


    public static Course createCourseFromResultSet(ResultSet rs) throws SQLException {

        Integer id = rs.getInt("crs_id");
        String name = rs.getString("course_name");

        return new Course(name, id);

    }

    public void saveCourse(Course course) {

        String query = "INSERT INTO course (course_name) VALUES(?)";

        try (PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(2, course.getName());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

