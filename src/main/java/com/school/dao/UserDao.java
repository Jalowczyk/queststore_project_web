package com.school.dao;

import com.school.models.Admin;
import com.school.models.Mentor;
import com.school.models.Student;
import com.school.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class UserDao extends AbstractDao {

    private static final String tableName = "users";
    private static Map<String, User> usersDict = new HashMap<>();

    public UserDao() {

        super(tableName);
        setUsersDict();
    }

    @Override
    public User load(String id) {

        String query = "SELECT first_name, last_name, password, id_number, email, status FROM users" +
                       " WHERE id_number = '" + id + "' ";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            if (rs.next()) {
                return createUser(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }

    public ArrayList<String> listSpecifiedUsers (String status){
        ArrayList<String> foundUsers = new ArrayList<String>();

        String query = "SELECT * FROM users WHERE status = '" + status + "' ";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                String recordFound;
                recordFound = String.format("%s - %s - %s - %s",
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("id_number8"),
                        rs.getString("email"));

                foundUsers.add(recordFound);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return foundUsers;
    }

    @Override
    public User createFromRow(String status, String name, String surname, String password, Integer id, String mail) {

        User user;

        user = usersDict.get(status);

        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        user.setMail(mail);
        user.setId(id);

        return user;
    }


    public User createUser(ResultSet rs) throws SQLException {

        String name = rs.getString("first_name");
        String surname = rs.getString("last_name");
        String password = rs.getString("password");
        Integer idNum = rs.getInt("id_number");
        String mail = rs.getString("email");
        String status = rs.getString("status");

        return createFromRow(status, name, surname, password, idNum, mail);

    }

    public static void setUsersDict() {

        usersDict.put("admin", new Admin());
        usersDict.put("mentor", new Mentor());
        usersDict.put("student", new Student());
    }

    @Override
    public void save(User user) {

        String query = "INSERT INTO users" +
                       "(first_name, last_name, password, email, status)" +
                       " VALUES(?,?,?,?,?)";

        try (PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getMail());
            statement.setString(5, user.getStatus());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



