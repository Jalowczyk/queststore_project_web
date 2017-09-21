package com.school.dao;

import com.school.models.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoMentor extends UserDao {

    private User mentor;

    public DaoMentor(User mentor) { this.mentor = mentor; }
    
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

        save(mentor);
    }
}
