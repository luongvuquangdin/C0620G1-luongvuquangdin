package bo.service_bo;

import dao.service_dao.ServiceTypeDAO;
import dao.service_dao.ServiceTypeDAOImpl;
import model.service.ServiceType;

import java.util.List;

public class ServiceTypeBOImpl implements ServiceTypeBO {
    ServiceTypeDAO serviceTypeDAO=new ServiceTypeDAOImpl();
    @Override
    public List<ServiceType> findAllServiceType() {
        return this.serviceTypeDAO.findAllServiceType();
    }
}
