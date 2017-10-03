package com.school.dao;

import com.school.models.User;

import java.sql.SQLException;
import java.sql.Statement;

public class MentorDAO extends UserDAO {

    private User mentor;

    public MentorDAO(User mentor) { this.mentor = mentor; }
    
    public static void editMentor(String first_name, Integer id) {

        String query = "UPDATE users SET first_name = '" + first_name + "'" +
                       "WHERE id_number = '" + id + "'";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save() {

        saveUser(mentor);
    }
}
