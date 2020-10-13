package bo.contract_detail_bo;

import dao.contract_detail_dao.AttachServiceDAO;
import dao.contract_detail_dao.AttachServiceDAOImpl;
import model.contract_detail.AttachService;

import java.util.List;

public class AttachServiceBOImpl implements AttachServiceBO {

    AttachServiceDAO attachServiceDAO=new AttachServiceDAOImpl();
    @Override
    public List<AttachService> findAllAttachService() {
        return this.attachServiceDAO.findAllAttachService();
    }
}
