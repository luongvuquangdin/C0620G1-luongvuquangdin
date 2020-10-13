package dao.service_dao;

import dao.customer_dao.ConnectDatabase;
import model.service.ServiceType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeDAOImpl implements ServiceTypeDAO {
    private static final String SELECT_ALL_SERVICE_TYPE= "Select "+
            "service_type_id," +
            "service_type_name " +
            "from service_type";
    @Override
    public List<ServiceType> findAllServiceType() {
        List<ServiceType> serviceTypeList=new ArrayList<>();
        try(Connection connection= ConnectDatabase.getConnect();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_SERVICE_TYPE);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id=resultSet.getString("service_type_id");
                String name=resultSet.getString("service_type_name");
                serviceTypeList.add(new ServiceType(id,name));
            }

        }catch (SQLException e){
            System.out.println(e);

        }

        return serviceTypeList;
    }
}
