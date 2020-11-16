package com.casestudy.repository.contract_detail_repository;


import com.casestudy.entity.contract_detail.AttachOfService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachServiceRepository extends JpaRepository<AttachOfService,Integer> {
}
