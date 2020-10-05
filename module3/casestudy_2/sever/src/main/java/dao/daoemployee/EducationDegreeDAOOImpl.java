package dao.daoemployee;

import dao.daocustomer.ConnectDatabase;
import model.modelemployee.Division;
import model.modelemployee.EducationDegree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeDAOOImpl implements EducationDegreeDAO {
    private static final String SELECT_ALL_EDUCATION= "Select "+
            "education_degree_id," +
            "education_degree_name " +
            "from education_degree";
    @Override
    public List<EducationDegree> findAllEducationDegree() {
        List<EducationDegree> educationDegreeList=new ArrayList<>();
        try(Connection connection= ConnectDatabase.getConnect();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_EDUCATION);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id=resultSet.getString("education_degree_id");
                String name=resultSet.getString("education_degree_name");
                educationDegreeList.add(new EducationDegree(id,name));
            }

        }catch (SQLException e){
            System.out.println(e);

        }

        return educationDegreeList;
    }
}
