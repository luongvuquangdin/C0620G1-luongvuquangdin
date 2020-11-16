package com.casestudy.repository.employee_repository;

import com.casestudy.entity.employee.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
