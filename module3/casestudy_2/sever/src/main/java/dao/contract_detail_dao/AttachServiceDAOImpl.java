package dao.contract_detail_dao;

import dao.customer_dao.ConnectDatabase;
import model.contract.Contract;
import model.contract_detail.AttachService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceDAOImpl implements AttachServiceDAO {
    private static final String SELECT_ALL_ATTACH_SERVICE= "Select "+
            "attach_service_id," +
            "attach_service_name," +
            "attach_service_cost," +
            "attach_service_unit," +
            "attach_service_status," +
            "from attach_service";
    @Override
    public List<AttachService> findAllAttachService() {
        List<AttachService> attachServiceList=new ArrayList<>();
        try(Connection connection= ConnectDatabase.getConnect();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_ATTACH_SERVICE)){
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String id=resultSet.getString("attach_service_id");
                String name=resultSet.getString("attach_service_name");
                String attachServiceCost=resultSet.getString("attach_service_cost");
                String attachServiceUnit=resultSet.getString("attach_service_unit");
                String attachServiceStatus=resultSet.getString("attach_service_status");
                attachServiceList.add(new AttachService(id,name,attachServiceCost,attachServiceUnit,attachServiceStatus));
            }

        }catch (SQLException e){
            System.out.println(e);
        }
        return attachServiceList;
    }
}
