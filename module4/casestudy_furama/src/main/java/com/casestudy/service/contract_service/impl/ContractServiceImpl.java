package com.casestudy.service.contract_service.impl;

import com.casestudy.entity.contract.Contract;
import com.casestudy.repository.contract_repository.ContractRepository;
import com.casestudy.service.contract_service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Override
    public List<Contract> findAllContract() {
        return this.contractRepository.findAll();
    }

    @Override
    public Contract findContractById(Integer contractId) {
        return this.contractRepository.findById(contractId).orElse(null);
    }

    @Override
    public void createContract(Contract contract) {
//        String message=null;
//        boolean checkDeposit= ValidateNumber.checkPositiveNumber(contract.getContractDeposit());
//        boolean checkTotalMoney= ValidateNumber.checkPositiveNumber(contract.getContractTotalMoney());
//        if (!checkDeposit) message="Deposit is positive Number";
//        else if (!checkTotalMoney) message="Total money of contract is positive Number";
         this.contractRepository.save(contract);
    }
}
