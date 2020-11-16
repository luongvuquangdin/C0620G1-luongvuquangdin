package com.casestudy.repository.service_repository;

import com.casestudy.entity.service.ServiceOfFurama;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceOfFurama,String> {
}
