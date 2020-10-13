package bo.employee_bo;

import dao.employee_dao.UserDAO;
import dao.employee_dao.UserDAOImpl;
import model.employee.User;

import java.util.List;

public class UserBOImpl implements UserBO {
    UserDAO userDAO=new UserDAOImpl();
    @Override
    public List<User> findAllUser() {
        return userDAO.findAllUser();
    }

    @Override
    public String findUser(User user) {
        return userDAO.findUser(user);
    }
}
