package com.casestudy.service.employee_service.impl;


import com.casestudy.entity.employee.EducationDegree;
import com.casestudy.repository.employee_repository.EducationDegreeRepository;
import com.casestudy.service.employee_service.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    EducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return educationDegreeRepository.findAll();
    }
}
