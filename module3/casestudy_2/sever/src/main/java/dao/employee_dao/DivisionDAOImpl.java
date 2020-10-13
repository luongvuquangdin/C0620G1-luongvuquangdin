package dao.employee_dao;

import dao.customer_dao.ConnectDatabase;
import model.employee.Division;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionDAOImpl implements DivisionDAO {
    private static final String SELECT_ALL_DIVISION= "Select "+
            "division_id," +
            "division_name " +
            "from division";
    @Override
    public List<Division> findAllDivision() {
        List<Division> divisionList=new ArrayList<>();
        try(Connection connection= ConnectDatabase.getConnect();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_DIVISION);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id=resultSet.getString("division_id");
                String name=resultSet.getString("division_name");
                divisionList.add(new Division(id,name));
            }

        }catch (SQLException e){
            System.out.println(e);

        }

        return divisionList;
    }
}
