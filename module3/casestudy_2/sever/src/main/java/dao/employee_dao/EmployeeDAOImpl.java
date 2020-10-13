package dao.employee_dao;

import dao.customer_dao.ConnectDatabase;
import model.employee.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    private static final String SELECT_ALL_EMPLOYEE= "Select "+
            "employee_id," +
            "employee_name," +
            "employee_birthday," +
            "employee_id_card," +
            "employee_salary," +
            "employee_phone," +
            "employee_email," +
            "employee_address," +
            "`position`.position_name,"+
            "education_degree.education_degree_name," +
            "division.division_name," +
            "user_name " +
            "from employee " +
            "left join `position` using (position_id) " +
            "left join education_degree using (education_degree_id) " +
            "left join division using (division_id);";

    private static final String SELECT_EMPLOYEE_BY_NAME = "select * from employee where employee_name like ?";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id =?";
    private static final String INSERT_EMPLOYEE_SQL   = "insert into employee values(?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_EMPLOYEE_SQL = "delete from employee where employee_id = ?;";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee set " +
            "employee_name= ?," +
            "employee_birthday= ?," +
            "employee_id_card= ?," +
            "employee_salary= ?," +
            "employee_phone= ?," +
            "employee_email= ?," +
            "employee_address= ?," +
            "position_id= ?," +
            "education_degree_id= ?," +
            "division_id= ?," +
            "user_name= ?" +
            "where employee_id =?;";
    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> listEmployee=new ArrayList<>();
        try(Connection connection= ConnectDatabase.getConnect();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_EMPLOYEE);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id=resultSet.getString("employee_id");
                String name=resultSet.getString("employee_name");
                String birthday=resultSet.getString("employee_birthday");
                String idCard=resultSet.getString("employee_id_card");
                String salary=resultSet.getString("employee_salary");
                String phone=resultSet.getString("employee_phone");
                String email=resultSet.getString("employee_email");
                String address=resultSet.getString("employee_address");
                String positionId=resultSet.getString("position_name");
                String educationDegreeId=resultSet.getString("education_degree_name");
                String divisionId=resultSet.getString("division_name");
                String userName=resultSet.getString("user_name");
                listEmployee.add(new Employee(id,name,birthday,idCard,salary,phone,email,address,positionId,educationDegreeId,divisionId,userName));
            }

        }catch (SQLException e){
            System.out.println(e);

        }

        return listEmployee;
    }

    @Override
    public String createEmployee(Employee employee) {
        try (Connection connection=ConnectDatabase.getConnect();
             PreparedStatement preparedStatement=connection.prepareStatement(INSERT_EMPLOYEE_SQL)){
            preparedStatement.setString(1,employee.getEmployeeId());
            preparedStatement.setString(2,employee.getEmployeeName());
            preparedStatement.setString(3,employee.getEmployeeBirthday());
            preparedStatement.setString(4,employee.getEmployeeIdCard());
            preparedStatement.setString(5,employee.getEmployeeSalary());
            preparedStatement.setString(6,employee.getEmployeePhone());
            preparedStatement.setString(7,employee.getEmployeeEmail());
            preparedStatement.setString(8,employee.getEmployeeAddress());
            preparedStatement.setString(9,employee.getPositionId());
            preparedStatement.setString(10,employee.getEducationDegreeId());
            preparedStatement.setString(11,employee.getDivisionId());
            preparedStatement.setString(12,employee.getUserName());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
        return "Ok";
    }

    @Override
    public Employee findEmployeeById(String id) {
        Employee employee=null;
        try (Connection connection=ConnectDatabase.getConnect();
             PreparedStatement preparedStatement=connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)){
            preparedStatement.setString(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            String employeeId=resultSet.getString("employee_id");
            String name=resultSet.getString("employee_name");
            String birthday=resultSet.getString("employee_birthday");
            String idCard=resultSet.getString("employee_id_card");
            String salary=resultSet.getString("employee_salary");
            String phone=resultSet.getString("employee_phone");
            String email=resultSet.getString("employee_email");
            String address=resultSet.getString("employee_address");
            String positionId=resultSet.getString("position_id");
            String educationDegreeId=resultSet.getString("education_degree_id");
            String divisionId=resultSet.getString("division_id");
            String userName=resultSet.getString("user_name");
            employee=new Employee(employeeId,name,birthday,idCard,salary,phone,email,address,positionId,educationDegreeId,divisionId,userName);
        }catch (SQLException e){
            System.out.println(e);
        }
        return employee;

    }

    @Override
    public String deleteEmployee(String id) {
        Employee employee=null;
        employee=this.findEmployeeById(id);
        if (employee==null){
            return "false";
        }
        try (Connection connection=ConnectDatabase.getConnect();
             PreparedStatement preparedStatement=connection.prepareStatement(DELETE_EMPLOYEE_SQL)){

            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e);
        }
        return "ok";
    }

    @Override
    public String editEmployee(Employee employee) {
        try (Connection connection=ConnectDatabase.getConnect();
             PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_EMPLOYEE_SQL)){
            preparedStatement.setString(1,employee.getEmployeeName());
            preparedStatement.setString(2,employee.getEmployeeBirthday());
            preparedStatement.setString(3,employee.getEmployeeIdCard());
            preparedStatement.setString(4,employee.getEmployeeSalary());
            preparedStatement.setString(5,employee.getEmployeePhone());
            preparedStatement.setString(6,employee.getEmployeeEmail());
            preparedStatement.setString(7,employee.getEmployeeAddress());
            preparedStatement.setString(8,employee.getPositionId());
            preparedStatement.setString(9,employee.getEducationDegreeId());
            preparedStatement.setString(10,employee.getDivisionId());
            preparedStatement.setString(11,employee.getUserName());
            preparedStatement.setString(12,employee.getEmployeeId());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
        return "Ok";
    }

    @Override
    public List<Employee> findEmployeeByName(String employeeName) {
        List<Employee> employeeList=new ArrayList<>();
        try (Connection connection=ConnectDatabase.getConnect();
             PreparedStatement preparedStatement=connection.prepareStatement(SELECT_EMPLOYEE_BY_NAME)){
            preparedStatement.setString(1,"%"+employeeName+"%");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                String salary = resultSet.getString("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                String positionId = resultSet.getString("position_id");
                String educationDegreeId = resultSet.getString("education_degree_id");
                String divisionId = resultSet.getString("division_id");
                String userName = resultSet.getString("user_name");
                employeeList.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, userName));
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return employeeList;
    }
}
