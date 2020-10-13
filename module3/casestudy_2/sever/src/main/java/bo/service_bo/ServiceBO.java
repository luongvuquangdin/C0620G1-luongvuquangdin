package bo.service_bo;

import model.service.Service;

import java.util.List;

public interface ServiceBO {
    List<Service> findAllService();
    Service findServiceById(String id);
    String createService(Service service);
}
