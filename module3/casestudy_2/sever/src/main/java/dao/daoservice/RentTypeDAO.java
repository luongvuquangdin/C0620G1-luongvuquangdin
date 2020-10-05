package dao.daoservice;

import model.service.RentType;
import model.service.ServiceType;

import java.util.List;

public interface RentTypeDAO {
    List<RentType> findAllRentType();
}
