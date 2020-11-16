package com.casestudy.service.service_services.impl;

import com.casestudy.entity.service.ServiceOfFurama;
import com.casestudy.repository.service_repository.ServiceRepository;
import com.casestudy.service.service_services.ServiceOfFuramaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceOfFuramaServiceImpl implements ServiceOfFuramaService {
    @Autowired
    ServiceRepository serviceRepository;


    @Override
    public Page<ServiceOfFurama> findAllService(Pageable pageable) {
        return this.serviceRepository.findAll(pageable);
    }

    @Override
    public List<ServiceOfFurama> findAllService() {
        return this.serviceRepository.findAll();
    }

    @Override
    public ServiceOfFurama findServiceById(String id) {
        return this.serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void createService(ServiceOfFurama service) {
//        String message=null;
//        boolean checkID= ValidateID.checkIdCustomer(service.getServiceId());
//        boolean checkArea= ValidateNumber.checkPositiveNumber(service.getServiceArea());
//        boolean checkPoolArea= ValidateNumber.checkPositiveNumber(service.getPoolArea());
//        boolean checkCost= ValidateNumber.checkPositiveNumber(service.getServiceCost());
//        boolean checkMaxPeople= ValidateNumber.checkPositiveInteger(service.getServiceMaxPeople());
//        boolean checkNumberFloor= ValidateNumber.checkPositiveInteger(service.getNumberOfFloors());
//        //check id
//        if (!checkID) message="Service id format is DV-XXXX (X is number 0-9)";
//        else if (!checkArea) message="Area is positive Number";
//        else if (!checkPoolArea) message="Pool area is positive Number";
//        else if (!checkCost) message="Cost is positive Number";
//        else if (!checkMaxPeople) message="Max people positive Integer";
//        else if (!checkNumberFloor) message="Number of floor is positive Integer";
//        else message = this.serviceDAO.createService(service);
//        return message;
        this.serviceRepository.save(service);
    }
}
