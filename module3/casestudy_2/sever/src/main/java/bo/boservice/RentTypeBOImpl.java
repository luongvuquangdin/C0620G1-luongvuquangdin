package bo.boservice;

import dao.daoservice.RentTypeDAO;
import dao.daoservice.RentTypeDAOImpl;
import model.service.RentType;

import java.util.List;

public class RentTypeBOImpl implements RentTypeBO {
    RentTypeDAO rentTypeDAO=new RentTypeDAOImpl();
    @Override
    public List<RentType> findAllRentType() {
        return this.rentTypeDAO.findAllRentType();
    }
}
