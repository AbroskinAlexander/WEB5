package AcessDB;

import Dao.HiberUserDao;
import Util.DBAccess;
import model.User;
import org.hibernate.SessionFactory;

import java.util.List;

public class ServiceClientHibernate {

    private static ServiceClientHibernate serviceClientHibernate;

    private SessionFactory sessionFactory;

    private ServiceClientHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static ServiceClientHibernate getInstance() {
        if (serviceClientHibernate == null) {
            serviceClientHibernate = new ServiceClientHibernate(DBAccess.getSessionFactory());
        }
        return serviceClientHibernate;
    }

    public boolean addUser(User user) {
        return new HiberUserDao(sessionFactory.openSession()).addUser(user);
    }

    public List<User> getAllUser() {
        return new HiberUserDao(sessionFactory.openSession()).getAllUser();
    }

    public User getUserById(long id) {
        return new HiberUserDao(sessionFactory.openSession()).getUserById(id);
    }

    public boolean userExist(User user) {
        return new HiberUserDao(sessionFactory.openSession()).userExist(user);
    }

    public void updateUser(User user) {
        new HiberUserDao(sessionFactory.openSession()).updateUser(user);
    }

    public void deletUser(long id) {
        new HiberUserDao(sessionFactory.openSession()).deletUser(id);
    }

    public void deletAllUsers() {
        new HiberUserDao(sessionFactory.openSession()).deletAllUsers();
    }

}
