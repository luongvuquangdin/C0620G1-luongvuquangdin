package com.casestudy.service.contract_detail_service;


import com.casestudy.entity.contract_detail.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAllContractDetail();
    ContractDetail findContractDetailById(Integer contractDetailId);
    void createContractDetail(ContractDetail contractDetail);
}
