package com.casestudy.service.contract_detail_service.impl;

import com.casestudy.entity.contract_detail.AttachOfService;
import com.casestudy.repository.contract_detail_repository.AttachServiceRepository;
import com.casestudy.service.contract_detail_service.AttachServiceOfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class AttachServiceServiceImpl implements AttachServiceOfService {
    @Autowired
    AttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachOfService> findAllAttachService() {
        return this.attachServiceRepository.findAll();
    }
}
