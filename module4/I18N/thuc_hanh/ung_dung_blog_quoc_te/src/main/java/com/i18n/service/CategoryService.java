package com.i18n.service;


import com.i18n.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Integer id);
    void save(Category category);
    void update(Category category);
    void delete(Integer id);

}
