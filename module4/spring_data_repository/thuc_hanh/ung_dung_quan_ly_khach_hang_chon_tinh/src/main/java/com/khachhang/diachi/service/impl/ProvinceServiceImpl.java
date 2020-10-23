package com.khachhang.diachi.service.impl;

import com.khachhang.diachi.entity.Province;
import com.khachhang.diachi.repository.ProvinceRepository;
import com.khachhang.diachi.service.ProvinceService;
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
    }
}
