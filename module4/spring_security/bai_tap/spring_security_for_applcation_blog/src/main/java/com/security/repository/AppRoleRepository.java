package com.security.repository;

import com.security.entity.AppRole;
import com.security.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
}
