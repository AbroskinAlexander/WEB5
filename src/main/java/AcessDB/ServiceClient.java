package AcessDB;

import Dao.UsersDao;
import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ServiceClient {
    private static Connection connection = null;

    public boolean addUser(User user) {
        return getUserDao().addUser(user);
    }

    public List<User> getAllUser() {
        return getUserDao().getAllUser();
    }

    public User getUserById(long id) {
        return getUserDao().getUserById(id);
    }

    public boolean userExist(User user) {
        return getUserDao().userExist(user);
    }

    public void updateUser(User user) {
        getUserDao().updateUser(user);
    }

    public void deletUser(long id) {
        getUserDao().deletUser(id);
    }

    public void deletAllUsers() {
        getUserDao().deletAllUsers();
    }

    public void createTable() {
        getUserDao().createTable();
    }

    public void dropTable() {
        getUserDao().dropTable();
    }

    private static Connection getMysqlConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                //   DriverManager.registerDriver((Driver)
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                String url = "jdbc:mysql://localhost:3306/web5?serverTimezone=UTC&user=root&password=1245";
                connection = DriverManager.getConnection(url);
                System.out.println("Get connection");
                return connection;
            }
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.out.println("Connection Erorr");
            e.printStackTrace();
            throw new IllegalStateException();
        }
        return connection;
    }

    private static UsersDao getUserDao() {
        return new UsersDao(getMysqlConnection());
    }
}
