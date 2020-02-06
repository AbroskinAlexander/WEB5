package Dao;

import model.User;

import java.util.List;

public interface DaoUsers {
    boolean addUser(User user);

    List<User> getAllUser();

    boolean userExist(User user);

    User getUserById(long id);

    void updateUser(User updateUser);

    void deletUser(long id);

    void deletAllUsers();

}
