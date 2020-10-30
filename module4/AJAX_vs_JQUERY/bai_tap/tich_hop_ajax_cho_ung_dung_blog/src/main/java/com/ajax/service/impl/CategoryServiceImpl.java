package com.ajax.service.impl;


import com.ajax.entity.Category;
import com.ajax.repository.CategoryRepository;
import com.ajax.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return this.categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        this.categoryRepository.deleteById(id);

    }
}
