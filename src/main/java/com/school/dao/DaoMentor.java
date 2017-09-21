package com.school.dao;

import com.school.models.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoMentor extends UserDao {

    private User mentor;

    public DaoMentor(User mentor) { this.mentor = mentor; }

    public void save() {

        save(mentor);

//        String query = "INSERT INTO mentors" +
//                       "(courses)" +
//                       " VALUES(?)";
//
//        try (PreparedStatement statement = conn.prepareStatement(query)) {
//
//            statement.setString(1, mentor.getName());
//            statement.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
