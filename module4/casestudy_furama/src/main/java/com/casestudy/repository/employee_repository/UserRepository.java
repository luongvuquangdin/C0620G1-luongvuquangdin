package com.casestudy.repository.employee_repository;

import com.casestudy.entity.employee.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
