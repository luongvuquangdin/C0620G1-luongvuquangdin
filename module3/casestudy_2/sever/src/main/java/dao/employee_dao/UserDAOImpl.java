package dao.employee_dao;

import dao.customer_dao.ConnectDatabase;
import model.employee.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    private static final String SELECT_ALL_USER= "Select "+
            "user_name," +
            "`password` " +
            "from `user`";

    private static final String SELECT_USER= "Select "+
            "user_name," +
            "`password` " +
            "from `user` " +
            "where user_name=? and `password`=?";

    @Override
    public List<User> findAllUser() {
        List<User> userList=new ArrayList<>();
        try(Connection connection= ConnectDatabase.getConnect();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_USER);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id=resultSet.getString("user_name");
                String name=resultSet.getString("password");
                userList.add(new User(id,name));
            }

        }catch (SQLException e){
            System.out.println(e);

        }

        return userList;
    }

    @Override
    public String findUser(User user) {
        try(Connection connection= ConnectDatabase.getConnect();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_USER);){
            preparedStatement.setString(1,user.getUserName());
            preparedStatement.setString(2,user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) return "NOTHING";
        }catch (SQLException e){
            System.out.println(e);
        }
        return "OK";

    }
}
