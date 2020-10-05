package bo.boemployee;

import dao.daoemployee.UserDAO;
import dao.daoemployee.UserDAOImpl;
import model.modelemployee.User;

import java.util.List;

public class UserBOImpl implements UserBO {
    UserDAO userDAO=new UserDAOImpl();
    @Override
    public List<User> findAllUser() {
        return userDAO.findAllUser();
    }
}
