package com.jqueryvsajax.repository;

import com.jqueryvsajax.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<Smartphone,Integer> {
}
