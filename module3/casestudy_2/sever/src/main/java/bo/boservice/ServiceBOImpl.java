package bo.boservice;

import dao.daoservice.ServiceDAO;
import dao.daoservice.ServiceDAOImpl;
import model.service.Service;

import java.util.List;

public class ServiceBOImpl implements ServiceBO {
    ServiceDAO serviceDAO=new ServiceDAOImpl();
    @Override
    public List<Service> findAllService() {
        return this.serviceDAO.findAllService();
    }

    @Override
    public Service findServiceById(String id) {
        return this.serviceDAO.findServiceById(id);
    }

    @Override
    public String createService(Service service) {
        return this.serviceDAO.createService(service);
    }
}
