package com.security.service.impl;

import com.security.entity.AppUser;
import com.security.entity.UserRole;
import com.security.repository.AppRoleRepository;
import com.security.repository.UserRoleRepository;
import com.security.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    AppRoleRepository appRoleRepository;

    @Override
    public void save(AppUser appUser, Long id) {
        this.userRoleRepository.save(new UserRole(appUser,this.appRoleRepository.findById(id).orElse(null)));
    }
}
