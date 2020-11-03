package com.security.service;

import com.security.entity.AppRole;
import com.security.entity.AppUser;

import java.util.List;

public interface AppRoleService {
    List<AppRole> findAll();
    AppRole findById(Long id);
}
