package src.dao;

import src.models.User;
import java.sql.*;


public abstract class AbstractDAO implements DAOInterface {

    private User person;

    private final String dataBasePath;
    private static Connection conn;

    public AbstractDAO(String path, User person) {

        this.person = person;
        this.dataBasePath = path;

        conn = connectToDataBase(this.dataBasePath);

    }

    public User load(String id) {

        User user = null;

        String query = "SELECT first_name, last_name, password, id_number, email FROM '" + dataBasePath + "'" +
                       " WHERE id_number = '" + id + "' ";

        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                return createUser(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return user;
    }

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

            conn = DriverManager.getConnection("jdbc:sqlite:com/sql/school.db");

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void save(User user) {

        String query = "INSERT INTO '" + dataBasePath + "' " +
                "(first_name, last_name, password, id_number, email)" +
                " VALUES(?,?,?,?,?)";


        try {

            PreparedStatement statement = conn.prepareStatement(query);


            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getId());
            statement.setString(5, user.getMail());

            statement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public User createUser(ResultSet rs) throws SQLException{

        String name = rs.getString("first_name");
        String surname = rs.getString("last_name");
        String password = rs.getString("password");
        String idNum = rs.getString("id_number");
        String mail = rs.getString("email");

        return createFromRow(name, surname, password, idNum, mail);

    }
}
