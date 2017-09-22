package com.school.dao;

import com.school.models.Admin;
import com.school.models.Mentor;
import com.school.models.Student;
import com.school.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class UserDao extends AbstractDao implements DAOUserInterface {

    private static final String tableName = "users";
    private static Map<String, User> usersDict = new HashMap<>();

    public UserDao() {

        super(tableName);
        setUsersDict();
    }

    @Override
    public User load(String id, String password) {

        String query = "SELECT first_name, last_name, password, id_number, email, status FROM users" +
                       " WHERE id_number = '" + id + "' AND password = '" + password + "'";

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

    public ArrayList<String> listSpecifiedData (String table, String status){
        ArrayList<String> foundData = new ArrayList<>();

        String query = "SELECT * FROM " + table + " WHERE status = '" + status + "' ";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                String recordFound;
                recordFound = String.format("ID: %s - Name: %s - Surname: %s - email: %s",
                        rs.getString("id_number"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"));

                foundData.add(recordFound);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return foundData;
    }

    @Override
    public User createFromRow(Integer id, String...values) {

        String status = values[0];
        String name = values[1];
        String surname = values[2];
        String password = values[3];
        String mail = values[4];

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

        String values[] = {status, name, surname, password, mail};

        return createFromRow(idNum, values);

    }

    public static void setUsersDict() {

        usersDict.put("admin", new Admin());
        usersDict.put("mentor", new Mentor());
        usersDict.put("student", new Student());
    }

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
    public ArrayList<String> getAllMentors (String status){
        ArrayList<String> foundMentors = new ArrayList<>();

        String query = "SELECT * FROM users WHERE status = '" + status + "' ";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                String recordFound;
                recordFound = String.format("%s - %s ",
                        rs.getString("first_name"),
                        rs.getString("last_name"));

                foundMentors.add(recordFound);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return foundMentors;
    }
    public ArrayList<String> getMentorDetails (String mentorName){
        ArrayList<String> foundMentor = new ArrayList<>();

        String query = "SELECT * FROM users WHERE first_name = '" + mentorName + "' ";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                String recordFound;
                recordFound = String.format("%s - %s - %s - %s",
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("id_number"),
                        rs.getString("email"));
                foundMentor.add(recordFound);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return foundMentor;
    }
}
