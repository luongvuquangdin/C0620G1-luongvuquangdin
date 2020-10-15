package services.impl;

import entity.Login;
import entity.User;
import org.springframework.stereotype.Service;
import services.UserDao;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao {
    private static List<User> users;

    static {
        users=new ArrayList<>();
        users.add(new User("john","123456","John","john@codegym.vn",10));
        users.add(new User("bill","123456","Bill","bill@codegym.vn",15));
        users.add(new User("mike","123456","Mike","mike@codegym.vn",16));
    }

    @Override
    public User checkLogin(Login login) {
        for (User u: users) {
            if(u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
