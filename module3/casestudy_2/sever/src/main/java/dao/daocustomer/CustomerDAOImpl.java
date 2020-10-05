package dao.daocustomer;

import model.modelcustomer.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO  {
    private static final String SELECT_ALL_CUSTOMER= "Select "+
            "customer_id," +
            "customer_name," +
            "customer_birthday," +
            "customer_gender," +
            "customer_id_card," +
            "customer_phone," +
            "customer_email," +
            "customer_address," +
            "customer.customer_type_id,"+
            "customer_type.customer_type_name " +
            "from customer " +
            "left join customer_type using (customer_type_id)";

    private static final String SELECT_CUSTOMER_BY_NAME = "select * from customer where customer_name like ?";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id =?";
    private static final String INSERT_CUSTOMER_SQL   = "insert into customer values(?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set " +
            "customer_name= ?," +
            "customer_birthday= ?," +
            "customer_gender= ?," +
            "customer_id_card= ?," +
            "customer_phone= ?," +
            "customer_email= ?," +
            "customer_address= ?," +
            "customer_type_id= ?" +
            "where customer_id =?;";
    @Override
    public List<Customer> findAllCustomer() {
        List<Customer> listCustomer=new ArrayList<>();
        try(Connection connection= ConnectDatabase.getConnect();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_CUSTOMER);){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id=resultSet.getString("customer_id");
                String name=resultSet.getString("customer_name");
                String birthday=resultSet.getString("customer_birthday");
                String gender=resultSet.getString("customer_gender");
                String idCard=resultSet.getString("customer_id_card");
                String phone=resultSet.getString("customer_phone");
                String email=resultSet.getString("customer_email");
                String address=resultSet.getString("customer_address");
                String typeId=resultSet.getString("customer_type_name");
                listCustomer.add(new Customer(id,name,birthday,gender,idCard,phone,email,address,typeId));
            }

        }catch (SQLException e){
            System.out.println(e);

        }

        return listCustomer;
    }

    @Override
    public String createCustomer(Customer customer) {
        Customer customer_1=this.findCustomerById(customer.getCustomerId());
        if (customer_1!=null){
            return customer.getCustomerId()+" is exist";
        }
        try (Connection connection=ConnectDatabase.getConnect();
             PreparedStatement preparedStatement=connection.prepareStatement(INSERT_CUSTOMER_SQL)){
            preparedStatement.setString(1,customer.getCustomerId());
            preparedStatement.setString(2,customer.getCustomerName());
            preparedStatement.setString(3,customer.getCustomerBirthday());
            preparedStatement.setString(4,customer.getCustomerGender());
            preparedStatement.setString(5,customer.getCustomerIdCard());
            preparedStatement.setString(6,customer.getCustomerPhone());
            preparedStatement.setString(7,customer.getCustomerEmail());
            preparedStatement.setString(8,customer.getCustomerAddress());
            preparedStatement.setString(9,customer.getCustomerTypeId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
        return "Ok";
    }

    @Override
    public Customer findCustomerById(String customerId) {
        Customer customer=null;
        try (Connection connection=ConnectDatabase.getConnect();
        PreparedStatement preparedStatement=connection.prepareStatement(SELECT_CUSTOMER_BY_ID)){
            preparedStatement.setString(1,customerId);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            String id= resultSet.getString("customer_id");
            String name=resultSet.getString("customer_name");
            String birthday=resultSet.getString("customer_birthday");
            String gender=resultSet.getString("customer_gender");
            String idCard=resultSet.getString("customer_id_card");
            String phone=resultSet.getString("customer_phone");
            String email=resultSet.getString("customer_email");
            String address=resultSet.getString("customer_address");
            String typeId=resultSet.getString("customer_type_id");
            customer=new Customer(id,name,birthday,gender,idCard,phone,email,address,typeId);
        }catch (SQLException e){
            System.out.println(e);
        }
        return customer;
    }

    @Override
    public String deleteCustomer(String id) {
        Customer customer=null;
        customer=this.findCustomerById(id);
        if (customer==null){
            return "false";
        }
        try (Connection connection=ConnectDatabase.getConnect();
             PreparedStatement preparedStatement=connection.prepareStatement(DELETE_CUSTOMER_SQL)){

            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e);
        }
        return "ok";
    }

    @Override
    public String editCustomer(Customer customer) {
        try (Connection connection=ConnectDatabase.getConnect();
             PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_CUSTOMER_SQL)){
            preparedStatement.setString(1,customer.getCustomerName());
            preparedStatement.setString(2,customer.getCustomerBirthday());
            preparedStatement.setString(3,customer.getCustomerGender());
            preparedStatement.setString(4,customer.getCustomerIdCard());
            preparedStatement.setString(5,customer.getCustomerPhone());
            preparedStatement.setString(6,customer.getCustomerEmail());
            preparedStatement.setString(7,customer.getCustomerAddress());
            preparedStatement.setString(8,customer.getCustomerTypeId());
            preparedStatement.setString(9,customer.getCustomerId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
        return "Ok";
    }

    @Override
    public List<Customer> findCustomerByName(String customerName) {
        List<Customer> listCustomer=new ArrayList<>();
        try(Connection connection=ConnectDatabase.getConnect();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_CUSTOMER_BY_NAME);){
            preparedStatement.setString(1,"%"+customerName+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id=resultSet.getString("customer_id");
                String name=resultSet.getString("customer_name");
                String birthday=resultSet.getString("customer_birthday");
                String gender=resultSet.getString("customer_gender");
                String idCard=resultSet.getString("customer_id_card");
                String phone=resultSet.getString("customer_phone");
                String email=resultSet.getString("customer_email");
                String address=resultSet.getString("customer_address");
                String typeId=resultSet.getString("customer_type_id");
                listCustomer.add(new Customer(id,name,birthday,gender,idCard,phone,email,address,typeId));
            }

        }catch (SQLException e){
            System.out.println(e);

        }

        return listCustomer;
    }

}
