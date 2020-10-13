package dao.contract_dao;

import dao.customer_dao.ConnectDatabase;
import model.contract.Contract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDAOImpl implements ContractDAO {
    private static final String SELECT_ALL_CONTRACT= "Select "+
            "contract_id," +
            "contract_start_date," +
            "contract_end_date," +
            "contract_deposit," +
            "contract_total_money," +
            "employee.employee_name," +
            "customer.customer_name," +
            "service.service_name " +
            "from contract " +
            "left join employee using (employee_id) "+
            "left join customer using (customer_id) "+
            "left join service using (service_id)";
    private static final String SELECT_CONTRACT_BY_ID = "select * from contract where contract_id =?";
    private static final String INSERT_CONTRACT_SQL   = "insert into contract values(?,?,?,?,?,?,?,?)";

    @Override
    public List<Contract> findAllContract() {
        List<Contract> contractList=new ArrayList<>();
        try(Connection connection= ConnectDatabase.getConnect();
            PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_CONTRACT)){
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String id=resultSet.getString("contract_id");
                String startDate=resultSet.getString("contract_start_date");
                String endDate=resultSet.getString("contract_end_date");
                String deposit=resultSet.getString("contract_deposit");
                String totalMoney=resultSet.getString("contract_total_money");
                String employeeName=resultSet.getString("employee_name");
                String customerName=resultSet.getString("customer_name");
                String service_name=resultSet.getString("service_name");
                contractList.add(new Contract(id,startDate,endDate,deposit,totalMoney,employeeName,customerName,service_name));
            }

        }catch (SQLException e){
            System.out.println(e);
        }
        return contractList;
    }

    @Override
    public Contract findContractById(String contractId) {
        Contract contract1=null;
        try(Connection connection=ConnectDatabase.getConnect();
        PreparedStatement preparedStatement=connection.prepareStatement(SELECT_CONTRACT_BY_ID)){
            preparedStatement.setString(1,contractId);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            String id=resultSet.getString("contract_id");
            String startDate=resultSet.getString("contract_start_date");
            String endDate=resultSet.getString("contract_end_date");
            String deposit=resultSet.getString("contract_deposit");
            String totalMoney=resultSet.getString("contract_total_money");
            String employeeName=resultSet.getString("employee_name");
            String customerName=resultSet.getString("customer_name");
            String service_name=resultSet.getString("service_name");
            contract1=new Contract(id,startDate,endDate,deposit,totalMoney,employeeName,customerName,service_name);

        }catch (SQLException e){
            System.out.println(e);
        }
        return contract1;
    }

    @Override
    public String createContract(Contract contract) {
        Contract contract1=this.findContractById(contract.getContractId());
        if (contract1!=null){
            return contract.getContractId() + " exist";
        }
        try(Connection connection=ConnectDatabase.getConnect();
        PreparedStatement preparedStatement=connection.prepareStatement(INSERT_CONTRACT_SQL)){
            preparedStatement.setString(1,contract.getContractId());
            preparedStatement.setString(2,contract.getContractStartDate());
            preparedStatement.setString(3,contract.getContractEndDate());
            preparedStatement.setString(4,contract.getContractDeposit());
            preparedStatement.setString(5,contract.getContractTotalMoney());
            preparedStatement.setString(6,contract.getEmployeeId());
            preparedStatement.setString(7,contract.getCustomerId());
            preparedStatement.setString(8,contract.getServiceId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }
        return "OK";
    }
}
