package com.casestudy.service.contract_service;

import com.casestudy.entity.contract.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> findAllContract();
    Contract findContractById(Integer contractId);
    void createContract(Contract contract);
}
