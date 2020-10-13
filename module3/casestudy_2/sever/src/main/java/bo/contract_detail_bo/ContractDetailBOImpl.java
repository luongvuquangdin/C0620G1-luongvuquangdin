package bo.contract_detail_bo;

import dao.contract_detail_dao.ContractDetailDAO;
import dao.contract_detail_dao.ContractDetailDAOImpl;
import model.contract_detail.ContractDetail;

import java.util.List;

public class ContractDetailBOImpl implements ContractDetailBO {
    ContractDetailDAO contractDetailDAO=new ContractDetailDAOImpl();
    @Override
    public List<ContractDetail> findAllContractDetail() {
        return this.contractDetailDAO.findAllContractDetail();
    }

    @Override
    public ContractDetail findContractDetailById(String contractDetailId) {
        return this.contractDetailDAO.findContractDetailById(contractDetailId);
    }

    @Override
    public String createContractDetail(ContractDetail contractDetail) {
        return this.contractDetailDAO.createContractDetail(contractDetail);
    }
}
