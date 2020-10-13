package bo.contract_bo;

import model.contract.Contract;

import java.util.List;

public interface ContractBO {
    List<Contract> findAllContract();
    Contract findContractById(String contractId);
    String createContract(Contract contract);
}
