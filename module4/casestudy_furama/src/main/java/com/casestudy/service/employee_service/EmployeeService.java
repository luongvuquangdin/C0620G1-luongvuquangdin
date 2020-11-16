package com.casestudy.service.employee_service;

import com.casestudy.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAllEmployee(Pageable pageable);
    void createEmployee(Employee employee);
    Employee findEmployeeById(Integer id);
    void deleteEmployee(Integer id);
    void editEmployee(Employee employee);
    Page<Employee> findEmployeeByName(String employeeName,Pageable pageable);
    List<Employee> findAllEmployee();
}
