package src.dao;

import src.models.User;
import java.sql.*;


public abstract class AbstractDAO implements DAOInterface {

    private User person;

    private final String dataBasePath;
    private final String dataBaseName;

    private static Connection connection;
    private static Statement st;
    private static ResultSet rs;

    public AbstractDAO(String dataBaseName, String path, User person) {

        this.person = person;
        this.dataBasePath = path;
        this.dataBaseName = dataBaseName;

        this.connection = connectToDataBase(this.dataBasePath);

    }

    @Override
    public User load(String id) {

        User user = null;

        try {

            st = connection.createStatement();
            String query = String.format("SELECT name, surname, password, login, mail FROM %s", dataBaseName);

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

    public static Connection connectToDataBase(String dataBasePath) {

        try {

            Class.forName("org.sqlite.JDBC");

            connection = DriverManager.getConnection(dataBasePath);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void save(User user) {

        try {

            String query = String.format("INSERT INTO %s (name,surname,password,login,mail)" +
                    "VALUES ( '" + user.getName() + "','" + user.getSurname() + "', " +
                    "'" + user.getPassword() + "', '" + user.getId() + "', '" + user.getMail() + "')",dataBaseName);

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            statement.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}

