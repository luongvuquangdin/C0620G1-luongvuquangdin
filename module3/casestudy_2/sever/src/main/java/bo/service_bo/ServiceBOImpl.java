package bo.service_bo;

import common.ValidateID;
import common.ValidateNumber;
import dao.service_dao.ServiceDAO;
import dao.service_dao.ServiceDAOImpl;
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
        String message=null;
        boolean checkID= ValidateID.checkIdCustomer(service.getServiceId());
        boolean checkArea= ValidateNumber.checkPositiveNumber(service.getServiceArea());
        boolean checkPoolArea= ValidateNumber.checkPositiveNumber(service.getPoolArea());
        boolean checkCost= ValidateNumber.checkPositiveNumber(service.getServiceCost());
        boolean checkMaxPeople= ValidateNumber.checkPositiveInteger(service.getServiceMaxPeople());
        boolean checkNumberFloor= ValidateNumber.checkPositiveInteger(service.getNumberOfFloors());
        //check id
        if (!checkID) message="Service id format is DV-XXXX (X is number 0-9)";
        else if (!checkArea) message="Area is positive Number";
        else if (!checkPoolArea) message="Pool area is positive Number";
        else if (!checkCost) message="Cost is positive Number";
        else if (!checkMaxPeople) message="Max people positive Integer";
        else if (!checkNumberFloor) message="Number of floor is positive Integer";
        else message = this.serviceDAO.createService(service);
        return message;
    }
}
