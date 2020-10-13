package bo.contract_detail_bo;

import model.contract_detail.ContractDetail;

import java.util.List;

public interface ContractDetailBO {
    List<ContractDetail> findAllContractDetail();
    ContractDetail findContractDetailById(String contractDetailId);
    String createContractDetail(ContractDetail contractDetail);
}
