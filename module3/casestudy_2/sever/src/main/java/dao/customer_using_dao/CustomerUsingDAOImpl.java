package dao.customer_using_dao;

import dao.customer_dao.ConnectDatabase;
import model.customer_using.CustomerUsing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUsingDAOImpl implements CustomerUsingDAO {
    private final String SELECT_CUSTOMER_USING_SERVICE="select c.customer_name,c.customer_id," +
            "ct.contract_id,group_concat(ats.attach_service_name) as attact_services " +
            "from customer c " +
            "inner join contract ct using (customer_id) " +
            "left join contract_detail using (contract_id) " +
            "left join attach_service ats using (attach_service_id) " +
            "where ct.contract_end_date>=curdate() " +
            "group by c.customer_id";
    @Override
    public List<CustomerUsing> findAllCustomerUsing() {
        List<CustomerUsing> customerUsingList=new ArrayList<>();
        try(Connection connection= ConnectDatabase.getConnect();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_CUSTOMER_USING_SERVICE);){
           ResultSet resultSet = preparedStatement.executeQuery();
           while (resultSet.next()){
               String customerId=resultSet.getString("customer_id");
               String customerName=resultSet.getString("customer_name");;
               String contactId=resultSet.getString("contract_id");;
               String attachServiceName=resultSet.getString("attact_services");
               customerUsingList.add(new CustomerUsing(customerId,customerName,contactId,attachServiceName));
           }
        }catch (SQLException e){
            System.out.println(e);
        }
        return customerUsingList;
    }
}
