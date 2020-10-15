package services;

import entity.Login;
import entity.User;

public interface UserDao {
    User checkLogin(Login login);
}
