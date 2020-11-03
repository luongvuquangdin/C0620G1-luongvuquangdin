package com.security.service;

import com.security.entity.AppUser;
import com.security.entity.UserRole;

public interface UserRoleService {
    void save(AppUser appUser, Long id);
}
