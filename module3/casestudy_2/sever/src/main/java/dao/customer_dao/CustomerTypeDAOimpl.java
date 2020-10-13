package dao.customer_dao;

import model.customer.CustomerType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeDAOimpl implements CustomerTypeDAO {
    private static final String SELECT_ALL_CUSTOMER_TYPE= "Select "+
            "customer_type_id," +
            "customer_type_name " +
            "from customer_type";
    @Override
    public List<CustomerType> findAllCustomerType() {
        List<CustomerType> listCustomerType=new ArrayList<>();
        try(Connection connection= ConnectDatabase.getConnect();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id=resultSet.getString("customer_type_id");
                String name=resultSet.getString("customer_type_name");
                listCustomerType.add(new CustomerType(id,name));
            }

        }catch (SQLException e){
            System.out.println(e);

        }

        return listCustomerType;
    }
}
