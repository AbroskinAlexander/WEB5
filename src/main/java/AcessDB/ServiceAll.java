package AcessDB;

import Dao.DaoUsers;
import Dao.HiberUserDao;
import Util.DBAccess;
import model.User;

import java.util.List;

public class ServiceAll {
    private static ServiceAll serviceAll;
    //выбор способа подключения
    DaoUsers daoUsers = new HiberUserDao(DBAccess.getSessionFactory());
    //DaoUsers daoUsers = new UsersDao();

    private ServiceAll(){}

    public static ServiceAll getInstance(){
        if (serviceAll==null){
            return new ServiceAll();
        }
        return serviceAll;
    }

    public boolean addUser(User user) {
        return daoUsers.addUser(user);
    }

    public List<User> getAllUser() {
        return daoUsers.getAllUser();
    }

    public User getUserById(long id) {
        return daoUsers.getUserById(id);
    }

    public boolean userExist(User user) {
        return daoUsers.userExist(user);
    }

    public void updateUser(User user) {
        daoUsers.updateUser(user);
    }

    public void deletUser(long id) {
        daoUsers.deletUser(id);
    }
}
