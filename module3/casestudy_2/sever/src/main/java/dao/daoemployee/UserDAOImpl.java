package dao.daoemployee;

import dao.daocustomer.ConnectDatabase;
import model.modelemployee.Position;
import model.modelemployee.User;

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
}
