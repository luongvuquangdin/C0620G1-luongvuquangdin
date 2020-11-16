package com.casestudy.service.service_services.impl;

import com.casestudy.entity.service.ServiceType;
import com.casestudy.repository.service_repository.ServiceTypeRepository;
import com.casestudy.service.service_services.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    ServiceTypeRepository serviceTypeRepository;
    @Override
    public List<ServiceType> findAllServiceType() {
        return this.serviceTypeRepository.findAll();
    }
}
