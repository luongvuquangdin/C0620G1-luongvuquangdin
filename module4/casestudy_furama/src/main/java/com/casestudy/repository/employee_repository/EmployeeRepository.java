package com.casestudy.repository.employee_repository;

import com.casestudy.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "select * from employee where concat(employee_name,'',employee_address,'') like %?1%",nativeQuery = true)
    Page<Employee> search(String employeeName, Pageable pageable);

}
