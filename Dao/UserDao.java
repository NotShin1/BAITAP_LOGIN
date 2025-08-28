package Dao;

import Model.User;

public interface UserDao {
    User get(String username,String password);
}
