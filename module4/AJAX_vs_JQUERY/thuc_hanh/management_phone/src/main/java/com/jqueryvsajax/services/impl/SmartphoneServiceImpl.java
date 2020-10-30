package com.jqueryvsajax.services.impl;

import com.jqueryvsajax.entity.Smartphone;
import com.jqueryvsajax.repository.SmartphoneRepository;
import com.jqueryvsajax.services.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SmartphoneServiceImpl implements SmartphoneService {
    @Autowired
    SmartphoneRepository smartphoneRepository;

    @Override
    public List<Smartphone> findAll() {
        return this.smartphoneRepository.findAll();
    }

    @Override
    public Smartphone findById(Integer id) {
        return this.smartphoneRepository.findById(id).orElse(null);
    }

    @Override
    public Smartphone save(Smartphone phone) {
        return this.smartphoneRepository.save(phone);
    }

    @Override
    public Smartphone remove(Integer id) {
        Smartphone smartphone=this.findById(id);
        return smartphone;
    }
}
