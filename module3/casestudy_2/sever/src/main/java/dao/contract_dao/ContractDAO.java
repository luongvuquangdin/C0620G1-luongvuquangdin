package dao.contract_dao;

import model.contract.Contract;

import java.util.List;

public interface ContractDAO {
    List<Contract> findAllContract();
    Contract findContractById(String contractId);
    String createContract(Contract contract);
}
