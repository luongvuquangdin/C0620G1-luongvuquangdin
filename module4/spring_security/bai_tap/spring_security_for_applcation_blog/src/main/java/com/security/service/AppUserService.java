package com.security.service;

import com.security.entity.AppUser;

import java.util.List;

public interface AppUserService {
    AppUser findByUserName(String userName);
    void save(AppUser appUser);
}
