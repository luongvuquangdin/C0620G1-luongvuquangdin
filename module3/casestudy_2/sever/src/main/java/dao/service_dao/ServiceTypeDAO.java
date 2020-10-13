package dao.service_dao;

import model.service.ServiceType;

import java.util.List;

public interface ServiceTypeDAO {
    List<ServiceType> findAllServiceType();
}
