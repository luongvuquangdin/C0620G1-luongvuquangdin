package bo.contract_bo;

import common.ValidateNumber;
import dao.contract_dao.ContractDAO;
import dao.contract_dao.ContractDAOImpl;
import model.contract.Contract;

import java.util.List;

public class ContractBOImpl implements ContractBO {
    ContractDAO contractDAO=new ContractDAOImpl();

    @Override
    public List<Contract> findAllContract() {
        return this.contractDAO.findAllContract();
    }

    @Override
    public Contract findContractById(String contractId) {
        return this.contractDAO.findContractById(contractId);
    }

    @Override
    public String createContract(Contract contract) {
        String message=null;
        boolean checkDeposit= ValidateNumber.checkPositiveNumber(contract.getContractDeposit());
        boolean checkTotalMoney= ValidateNumber.checkPositiveNumber(contract.getContractTotalMoney());
        if (!checkDeposit) message="Deposit is positive Number";
        else if (!checkTotalMoney) message="Total money of contract is positive Number";
        return this.contractDAO.createContract(contract);
    }
}
