package com.casestudy.repository.contract_detail_repository;

import com.casestudy.entity.contract_detail.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
}
