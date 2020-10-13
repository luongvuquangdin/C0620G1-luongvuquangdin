package dao.contract_detail_dao;

import dao.customer_dao.ConnectDatabase;
import model.contract.Contract;
import model.contract_detail.ContractDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailDAOImpl implements ContractDetailDAO {

    private static final String SELECT_ALL_CONTRACT_DETAIL = "Select " +
            "contract_detail_id," +
            "quantity," +
            "contract_id," +
            "attach_service.attach_service_name " +
            "from contract_detail " +
            "left join attach_service using (attach_service_id)";
    private static final String SELECT_CONTRACT_DETAIL_BY_ID = "select * from contract_detail where contract_detail_id =?";
    private static final String INSERT_CONTRACT_DETAIL_SQL = "insert into contract_detail values(?,?,?,?)";

    @Override
    public List<ContractDetail> findAllContractDetail() {
        List<ContractDetail> contractDetailList = new ArrayList<>();
        try (Connection connection = ConnectDatabase.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAIL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("contract_detail_id");
                String quantity = resultSet.getString("quantity");
                String contractId = resultSet.getString("contract_id");
                String attachServiceName = resultSet.getString("attach_service_name");
                contractDetailList.add(new ContractDetail(id, quantity, contractId, attachServiceName));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return contractDetailList;
    }

    @Override
    public ContractDetail findContractDetailById(String contractDetailId) {
        ContractDetail contractDetail = null;
        try (Connection connection = ConnectDatabase.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_DETAIL_BY_ID)) {
            preparedStatement.setString(1, contractDetailId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String id = resultSet.getString("contract_detail_id");
            String quantity = resultSet.getString("quantity");
            String contractId = resultSet.getString("contract_id");
            String attachServiceName = resultSet.getString("attach_service_name");
            contractDetail = new ContractDetail(id, quantity, contractId, attachServiceName);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return contractDetail;
    }

    @Override
    public String createContractDetail(ContractDetail contractDetail) {
        ContractDetail contract1 = this.findContractDetailById(contractDetail.getContractDetailId());
        if (contract1 != null) {
            return contractDetail.getContractDetailId() + " exist";
        }
        try (Connection connection = ConnectDatabase.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_DETAIL_SQL)) {
            preparedStatement.setString(1, contractDetail.getContractDetailId());
            preparedStatement.setString(2, contractDetail.getQuantity());
            preparedStatement.setString(3, contractDetail.getContractId());
            preparedStatement.setString(4, contractDetail.getAttachServiceId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return "OK";
    }
}
