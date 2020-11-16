package com.casestudy.service.contract_detail_service.impl;

import com.casestudy.entity.contract_detail.ContractDetail;
import com.casestudy.repository.contract_detail_repository.ContractDetailRepository;
import com.casestudy.service.contract_detail_service.ContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements ContractDetailService {
    @Autowired
    ContractDetailRepository contractDetailRepository;
    @Override
    public List<ContractDetail> findAllContractDetail() {
        return this.contractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findContractDetailById(Integer contractDetailId) {
        return this.contractDetailRepository.findById(contractDetailId).orElse(null);
    }

    @Override
    public void createContractDetail(ContractDetail contractDetail) {
        this.contractDetailRepository.save(contractDetail);
    }
}
