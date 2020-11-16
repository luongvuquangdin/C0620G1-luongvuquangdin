package com.casestudy.repository.contract_repository;


import com.casestudy.entity.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract,Integer> {
}
