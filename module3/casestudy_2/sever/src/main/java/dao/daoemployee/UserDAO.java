package dao.daoemployee;

import model.modelemployee.User;

import java.util.List;

public interface UserDAO {
    List<User> findAllUser();
}
