package com.casestudy.service.employee_service.impl;

import com.casestudy.entity.employee.Role;
import com.casestudy.repository.employee_repository.RoleRepository;
import com.casestudy.service.employee_service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return this.roleRepository.findAll();
    }
}
