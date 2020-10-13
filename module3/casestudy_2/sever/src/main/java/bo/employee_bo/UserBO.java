package bo.employee_bo;

import model.employee.User;

import java.util.List;

public interface UserBO {
    List<User> findAllUser();
    String findUser(User user);
}
