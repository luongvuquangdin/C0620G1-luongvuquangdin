package com.casestudy.service.employee_service;

import com.casestudy.entity.employee.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    User findById(String id);
    void createUser(User user);

    void deleteUser(User user);
}
