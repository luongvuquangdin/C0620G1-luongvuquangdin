package dao.service_dao;

import model.service.Service;

import java.util.List;

public interface ServiceDAO {
    List<Service> findAllService();
    Service findServiceById(String id);
    String createService(Service service);
}
