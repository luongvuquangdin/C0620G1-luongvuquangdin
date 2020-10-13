package dao.employee_dao;

import dao.customer_dao.ConnectDatabase;
import model.employee.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDAOImpl implements PositionDAO {
    private static final String SELECT_ALL_POSITION= "Select "+
            "position_id," +
            "position_name " +
            "from `position`";
    @Override
    public List<Position> findAllPosition() {
        List<Position> positionList=new ArrayList<>();
        try(Connection connection= ConnectDatabase.getConnect();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_POSITION);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id=resultSet.getString("position_id");
                String name=resultSet.getString("position_name");
                positionList.add(new Position(id,name));
            }

        }catch (SQLException e){
            System.out.println(e);

        }

        return positionList;
    }
}
