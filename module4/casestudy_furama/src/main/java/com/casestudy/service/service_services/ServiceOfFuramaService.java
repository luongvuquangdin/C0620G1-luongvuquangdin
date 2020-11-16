package com.casestudy.service.service_services;


import com.casestudy.entity.service.ServiceOfFurama;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceOfFuramaService {
    Page<ServiceOfFurama> findAllService(Pageable pageable);
    List<ServiceOfFurama> findAllService();
    ServiceOfFurama findServiceById(String id);
    void createService(ServiceOfFurama service);
}
