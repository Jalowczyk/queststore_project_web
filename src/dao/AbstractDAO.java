package src.dao;

import src.models.User;
import java.sql.*;


public abstract class AbstractDAO implements DAOInterface {

    private final String dataBasePath;
    private final String dataBaseNameToSave;
    private Connection con;
    private User person;

    private static Statement st;
    private static ResultSet rs;

    public AbstractDAO(String dataBaseNameToSave, String path, User person) {
        this.person = person;
        this.dataBasePath = path;
        this.dataBaseNameToSave = dataBaseNameToSave;
    }

    @Override
    public User load(String id) {

        Connection con = connectToDataBase();
        User user = null;

        try {

            st = con.createStatement();
            String query = "SELECT name, surname, password, login, mail FROM admins";

            rs = st.executeQuery(query);

            while(rs.next()) {

                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String password = rs.getString("password");
                String idNum = rs.getString("login");
                String mail = rs.getString("mail");

                if (idNum.equals(id)) {
                    user = createFromRow(name, surname, password, idNum, mail);
                }

            rs.close();
            st.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User createFromRow(String name, String surname, String password, String id, String mail) {

        User user = this.person;

        user.setName(name);
        user.setSurname(surname);
        user.setPassword(password);
        user.setId(id);
        user.setMail(mail);

        return user;
    }

    public Connection connectToDataBase() {

        try {

            Class.forName("org.sqlite.JDBC");

            con = DriverManager.getConnection(dataBasePath);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

    @Override
    public void save(User user) {

        Connection con = connectToDataBase();

        try {

            String query = dataBaseNameToSave +
                    "VALUES ( '" + user.getName() + "','" + user.getSurname() + "', " +
                    "'" + user.getPassword() + "', '" + user.getId() + "', '" + user.getMail() + "')";

            Statement statement = con.createStatement();
            statement.executeUpdate(query);

            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();
            System.out.println("no connectToDataBase");
        }
    }
}

