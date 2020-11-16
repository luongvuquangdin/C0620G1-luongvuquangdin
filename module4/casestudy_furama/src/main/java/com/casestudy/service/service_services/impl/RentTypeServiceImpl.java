package com.casestudy.service.service_services.impl;

import com.casestudy.entity.service.RentType;
import com.casestudy.repository.service_repository.RentTypeRepository;
import com.casestudy.service.service_services.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    RentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAllRentType() {
        return this.rentTypeRepository.findAll();
    }
}
