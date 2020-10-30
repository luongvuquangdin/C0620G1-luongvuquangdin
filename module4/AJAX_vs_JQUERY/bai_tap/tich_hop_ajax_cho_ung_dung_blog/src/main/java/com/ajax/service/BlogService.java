package com.ajax.service;

import com.ajax.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    Blog findById(Integer id);
    void save(Blog blog);
    void update(Blog blog);
    void delete(Integer id);
    List<Blog> findAll();
    List<Blog> findAllByCategory_NameCategory(String name);
}
