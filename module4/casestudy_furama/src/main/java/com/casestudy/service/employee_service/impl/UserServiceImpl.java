package com.casestudy.service.employee_service.impl;

import com.casestudy.entity.employee.User;
import com.casestudy.repository.employee_repository.UserRepository;
import com.casestudy.service.employee_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public void createUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        this.userRepository.delete(user);
    }

}
