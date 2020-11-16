package com.casestudy.service.employee_service.impl;

import com.casestudy.entity.employee.Employee;
import com.casestudy.repository.employee_repository.EmployeeRepository;
import com.casestudy.service.employee_service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAllEmployee(Pageable pageable) {
        return this.employeeRepository.findAll(pageable);
    }

    @Override
    public void createEmployee(Employee employee) {
//        String message=null;
//        boolean checkNumberPhone= ValidateNumber.checkPhone(employee.getEmployeePhone());
//        boolean checkIdCard=ValidateNumber.checkIdCard(employee.getEmployeeIdCard());
//        boolean checkEmail= ValidateEmail.checkEmail(employee.getEmployeeEmail());
//        boolean checkSalary= ValidateNumber.checkPositiveNumber(employee.getEmployeeSalary());
//        if (!checkNumberPhone) message="Phone number format is 090XXXXXXX or 091XXXXXXX or (84)+90XXXXXXX or (84)+91XXXXXXX";
//        else if (!checkIdCard) message="Customer id card format is XXXXXXXXX (X is number 0-9)";
//        else if (!checkEmail) message="Email format is abc@gmail.com";
//        else if (!checkSalary) message="Salary is positive Number";
//        else message=employeeDAO.createEmployee(employee);
//        return message;
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEmployee(Integer id) {
         employeeRepository.deleteById(id);
    }

    @Override
    public void editEmployee(Employee employee) {
//        String message=null;
//        boolean checkNumberPhone= ValidateNumber.checkPhone(employee.getEmployeePhone());
//        boolean checkIdCard=ValidateNumber.checkIdCard(employee.getEmployeeIdCard());
//        boolean checkEmail= ValidateEmail.checkEmail(employee.getEmployeeEmail());
//        if (!checkNumberPhone) message="Phone number format is 090XXXXXXX or 091XXXXXXX or (84)+90XXXXXXX or (84)+91XXXXXXX";
//        else if (!checkIdCard) message="Customer id card format is XXXXXXXXX (X is number 0-9)";
//        else if (!checkEmail) message="Email format is abc@gmail.com";
//        else message=employeeDAO.editEmployee(employee);
//        return message;
        this.employeeRepository.save(employee);
    }



    @Override
    public Page<Employee> findEmployeeByName(String employeeName,Pageable pageable) {
        return employeeRepository.search(employeeName,pageable);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return this.employeeRepository.findAll();
    }
}
