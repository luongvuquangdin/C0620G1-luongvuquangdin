package com.end.services;

import com.end.entity.TypeProduct;

import java.util.List;

public interface TypeProductService {
    List<TypeProduct> findAll();
    TypeProduct findById(Integer id);
}
