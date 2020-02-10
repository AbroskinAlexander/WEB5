package org.hometask.service;

import org.hometask.model.User;

import java.util.List;

public interface UserService {

    boolean addUser(User user);

    List<User> getAllUser();

    User getUserById(Long id);

    boolean userExist(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User getUserByEmail(String email);
}
