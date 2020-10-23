package com.registration.registration.service.impl;

import com.registration.registration.entity.User;
import com.registration.registration.repository.FormRegistrationRepository;
import com.registration.registration.service.FormRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FormRegistrationServiceImpl implements FormRegistrationService {
    @Autowired
    FormRegistrationRepository registrationRepository;


    @Override
    public Page<User> findAll(Pageable pageable) {
        return this.registrationRepository.findAll(pageable);
    }

    @Override
    public void save(User user) {
        this.registrationRepository.save(user);

    }
}
