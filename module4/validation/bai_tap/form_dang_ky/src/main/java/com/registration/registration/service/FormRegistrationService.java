package com.registration.registration.service;

import com.registration.registration.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FormRegistrationService {

    Page<User> findAll(Pageable pageable);
    void save(User user);
}
