package org.hometask.dao;

import org.hometask.model.User;

import java.util.List;

public interface UserDAO {
    boolean addUser(User user);

    List<User> getAllUser();

    boolean userExist(User user);

    User getUserById(Long id);

    void updateUser(User updateUser);

    void deletUser(Long id);

    void deletAllUsers();

}
