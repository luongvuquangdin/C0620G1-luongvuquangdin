package com.security.service.impl;

import com.security.entity.AppRole;
import com.security.repository.AppRoleRepository;
import com.security.service.AppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppRoleServiceImpl implements AppRoleService {
    @Autowired
    AppRoleRepository appRoleRepository;
    @Override
    public List<AppRole> findAll() {
        return appRoleRepository.findAll();
    }

    @Override
    public AppRole findById(Long id) {
        return this.appRoleRepository.findById(id).orElse(null);
    }

}
