package dao.service_dao;

import dao.customer_dao.ConnectDatabase;
import model.service.RentType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeDAOImpl implements RentTypeDAO {
    private static final String SELECT_ALL_RENT_TYPE= "Select "+
            "rent_type_id," +
            "rent_type_name " +
            "from rent_type";
    @Override
    public List<RentType> findAllRentType() {
        List<RentType> rentTypeList=new ArrayList<>();
        try(Connection connection= ConnectDatabase.getConnect();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_RENT_TYPE);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id=resultSet.getString("rent_type_id");
                String name=resultSet.getString("rent_type_name");
                rentTypeList.add(new RentType(id,name));
            }

        }catch (SQLException e){
            System.out.println(e);
        }
        return rentTypeList;
    }
}
