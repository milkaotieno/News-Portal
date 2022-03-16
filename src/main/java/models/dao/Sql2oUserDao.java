package models.dao;

//public class Sql2oUserDao {
//}

import java.util.List;

interface UserDao {

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

