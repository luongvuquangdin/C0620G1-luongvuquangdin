package bo.service_bo;

import dao.service_dao.RentTypeDAO;
import dao.service_dao.RentTypeDAOImpl;
import model.service.RentType;

import java.util.List;

public class RentTypeBOImpl implements RentTypeBO {
    RentTypeDAO rentTypeDAO=new RentTypeDAOImpl();
    @Override
    public List<RentType> findAllRentType() {
        return this.rentTypeDAO.findAllRentType();
    }
}
