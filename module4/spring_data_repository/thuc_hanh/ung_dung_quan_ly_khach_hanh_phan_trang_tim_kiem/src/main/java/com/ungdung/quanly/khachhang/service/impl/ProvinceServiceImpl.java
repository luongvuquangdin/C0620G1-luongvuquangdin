package com.ungdung.quanly.khachhang.service.impl;


import com.ungdung.quanly.khachhang.entity.Province;
import com.ungdung.quanly.khachhang.repository.ProvinceRepository;
import com.ungdung.quanly.khachhang.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public List<Province> findAll() {
        return this.provinceRepository.findAll();
    };
}
