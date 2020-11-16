package com.end.services.impl;

import com.end.entity.TypeProduct;
import com.end.repository.TypeProductRepository;
import com.end.services.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductServiceImpl implements TypeProductService {
    @Autowired
    TypeProductRepository typeProductRepository;
    @Override
    public List<TypeProduct> findAll() {
        return this.typeProductRepository.findAll();
    }

    @Override
    public TypeProduct findById(Integer id) {
        return this.typeProductRepository.findById(id).orElse(null);
    }
}
