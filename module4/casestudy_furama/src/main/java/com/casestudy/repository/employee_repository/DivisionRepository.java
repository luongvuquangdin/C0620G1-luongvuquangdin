package com.casestudy.repository.employee_repository;

import com.casestudy.entity.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division,Integer> {
}
