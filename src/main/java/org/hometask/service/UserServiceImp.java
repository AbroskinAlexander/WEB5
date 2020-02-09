package org.hometask.service;

import org.hometask.dao.UserDAO;
import org.hometask.dao.UserDaoFactory;
import org.hometask.model.User;

import java.util.List;

public class UserServiceImp implements UserService {
    private static UserServiceImp userServiceImp;
    private UserDAO userDao;

    private UserServiceImp() {
        userDao = UserDaoFactory.getInstance().getUserDaoFactory();
    }

    public static UserServiceImp getInstance() {
        if (userServiceImp == null) {
            userServiceImp = new UserServiceImp();
            return userServiceImp;
        }
        return userServiceImp;
    }

    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public boolean userExist(User user) {
        return userDao.userExist(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deletUser(Long id) {
        userDao.deletUser(id);
    }
}
