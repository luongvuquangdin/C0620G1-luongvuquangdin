package com.casestudy.repository.service_repository;


import com.casestudy.entity.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}
