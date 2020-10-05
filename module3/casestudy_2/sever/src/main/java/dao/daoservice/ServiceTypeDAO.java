package dao.daoservice;

import model.service.ServiceType;

import java.util.List;

public interface ServiceTypeDAO {
    List<ServiceType> findAllServiceType();
}
