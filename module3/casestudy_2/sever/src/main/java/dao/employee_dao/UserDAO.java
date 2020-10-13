package dao.employee_dao;

import model.employee.User;

import java.util.List;

public interface UserDAO {
    List<User> findAllUser();
    String findUser(User user);
}
