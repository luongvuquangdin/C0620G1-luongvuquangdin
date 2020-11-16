package com.casestudy.service.employee_service.impl;

import com.casestudy.entity.employee.Division;
import com.casestudy.repository.employee_repository.DivisionRepository;
import com.casestudy.service.employee_service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    DivisionRepository divisionRepository;
    @Override
    public List<Division> findAllDivision() {
        return divisionRepository.findAll();
    }
}
