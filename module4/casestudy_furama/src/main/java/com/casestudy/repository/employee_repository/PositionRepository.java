package com.casestudy.repository.employee_repository;

import com.casestudy.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position,Integer> {
}
