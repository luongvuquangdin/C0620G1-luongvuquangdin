package com.casestudy.service.employee_service.impl;

import com.casestudy.entity.employee.Position;
import com.casestudy.repository.employee_repository.PositionRepository;
import com.casestudy.service.employee_service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;
    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAll();
    }
}
