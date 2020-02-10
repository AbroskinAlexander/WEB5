package org.hometask.service;

import org.hometask.dao.UserDAO;
import org.hometask.dao.UserDaoFactory;
import org.hometask.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl userServiceImpl;
    private UserDAO userDao;

    private UserServiceImpl() {
        userDao = UserDaoFactory.getInstance().getUserDaoFactory();
    }

    public static UserServiceImpl getInstance() {
        if (userServiceImpl == null) {
            userServiceImpl = new UserServiceImpl();
            return userServiceImpl;
        }
        return userServiceImpl;
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public boolean userExist(User user) {
        return userDao.userExist(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }
}
