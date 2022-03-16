package models.dao;

import java.util.List;

public interface User {
    //create
    void addUser(User user);

    //read
    List<User> getAllUsers();
    User getUserById(int id);

    //update

    //delete
    void deleteUsers();
    void deleteUserById(int id);
}
