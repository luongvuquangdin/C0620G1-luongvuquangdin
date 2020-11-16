package com.security.service.impl;

import com.security.entity.AppUser;
import com.security.repository.AppUserRepository;
import com.security.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public AppUser findByUserName(String userName) {
        return this.appUserRepository.findByUserName(userName);
    }

    @Override
    public void save(AppUser appUser) {
        this.appUserRepository.save(appUser);
    }

    @Override
    public List<AppUser> findAll() {
        return this.appUserRepository.findAll();
    }
}
