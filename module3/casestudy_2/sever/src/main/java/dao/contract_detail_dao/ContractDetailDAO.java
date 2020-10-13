package dao.contract_detail_dao;

import model.contract.Contract;
import model.contract_detail.AttachService;
import model.contract_detail.ContractDetail;

import java.util.List;

public interface ContractDetailDAO {
    List<ContractDetail> findAllContractDetail();
    ContractDetail findContractDetailById(String contractDetailId);
    String createContractDetail(ContractDetail contractDetail);
}
