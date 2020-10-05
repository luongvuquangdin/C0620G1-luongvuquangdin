package bo.boservice;

import dao.daoservice.ServiceTypeDAO;
import dao.daoservice.ServiceTypeDAOImpl;
import model.service.ServiceType;

import java.util.List;

public class ServiceTypeBOImpl implements ServiceTypeBO {
    ServiceTypeDAO serviceTypeDAO=new ServiceTypeDAOImpl();
    @Override
    public List<ServiceType> findAllServiceType() {
        return this.serviceTypeDAO.findAllServiceType();
    }
}
