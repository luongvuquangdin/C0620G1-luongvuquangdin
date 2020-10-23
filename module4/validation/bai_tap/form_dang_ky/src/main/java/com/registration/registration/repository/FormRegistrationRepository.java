package com.registration.registration.repository;

import com.registration.registration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRegistrationRepository extends JpaRepository<User,Integer> {
}
