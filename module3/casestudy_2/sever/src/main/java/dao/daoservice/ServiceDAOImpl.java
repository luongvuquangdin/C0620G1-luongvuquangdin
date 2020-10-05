package dao.daoservice;

import dao.daocustomer.ConnectDatabase;
import model.modelcustomer.Customer;
import model.modelemployee.Employee;
import model.service.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAOImpl implements ServiceDAO {
    private static final String SELECT_ALL_SERVICE= "Select "+
            "service_id," +
            "service_name," +
            "service_area," +
            "service_cost," +
            "service_max_people," +
            "standard_room," +
            "description_other_convenience," +
            "pool_area," +
            "number_of_floors,"+
            "rent_type.rent_type_name," +
            "service_type.service_type_name " +
            "from service " +
            "left join rent_type using (rent_type_id) " +
            "left join service_type using (service_type_id);";

    private static final String SELECT_SERVICE_BY_ID = "select * from service where service_id =?";
    private static final String INSERT_SERVICE_SQL   = "insert into service values(?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public List<Service> findAllService(){
        List<Service> serviceList=new ArrayList<>();
        try(Connection connection= ConnectDatabase.getConnect();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_SERVICE);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id=resultSet.getString("service_id");
                String name=resultSet.getString("service_name");
                String area=resultSet.getString("service_area");
                String cost=resultSet.getString("service_cost");
                String maxPeople=resultSet.getString("service_max_people");
                String standardRoom=resultSet.getString("standard_room");
                String descriptionOtherConvenience=resultSet.getString("description_other_convenience");
                String poolArea=resultSet.getString("pool_area");
                String numberOfFloors=resultSet.getString("number_of_floors");
                String rentTypeName=resultSet.getString("rent_type_name");
                String typeName=resultSet.getString("service_type_name");
                serviceList.add(new Service(id,name,area,cost,maxPeople,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors,rentTypeName,typeName));
            }

        }catch (SQLException e){
            System.out.println(e);

        }

        return serviceList;
    }

    @Override
    public Service findServiceById(String id) {
        Service service=null;
        try (Connection connection=ConnectDatabase.getConnect();
             PreparedStatement preparedStatement=connection.prepareStatement(SELECT_SERVICE_BY_ID)){
            preparedStatement.setString(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            String name=resultSet.getString("service_name");
            String area=resultSet.getString("service_area");
            String cost=resultSet.getString("service_cost");
            String maxPeople=resultSet.getString("service_max_people");
            String standardRoom=resultSet.getString("standard_room");
            String descriptionOtherConvenience=resultSet.getString("description_other_convenience");
            String poolArea=resultSet.getString("pool_area");
            String numberOfFloors=resultSet.getString("number_of_floors");
            String rentTypeName=resultSet.getString("rent_type_name");
            String typeName=resultSet.getString("service_type_name");
            service=new Service(id,name,area,cost,maxPeople,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors,rentTypeName,typeName);
        }catch (SQLException e){
            System.out.println(e);
        }
        return service;
    }

    @Override
    public String createService(Service service) {
        Service service1=this.findServiceById(service.getServiceId());
        if (service1!=null){
            return service.getServiceId() + " is exist";
        }
        try (Connection connection=ConnectDatabase.getConnect();
             PreparedStatement preparedStatement=connection.prepareStatement(INSERT_SERVICE_SQL)){
            preparedStatement.setString(1,service.getServiceId());
            preparedStatement.setString(2,service.getServiceName());
            preparedStatement.setString(3,service.getServiceArea());
            preparedStatement.setString(4,service.getServiceCost());
            preparedStatement.setString(5,service.getServiceMaxPeople());
            preparedStatement.setString(6,service.getStandardRoom());
            preparedStatement.setString(7,service.getDescriptionOtherConvenience());
            preparedStatement.setString(8,service.getPoolArea());
            preparedStatement.setString(9,service.getNumberOfFloors());
            preparedStatement.setString(10,service.getRentTypeId());
            preparedStatement.setString(11,service.getServiceTypeId());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
        return "Ok";

    }
}
