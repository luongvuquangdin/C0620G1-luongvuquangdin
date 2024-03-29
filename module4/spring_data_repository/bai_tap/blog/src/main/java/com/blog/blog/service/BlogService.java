package com.blog.blog.service;

import com.blog.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    Blog findById(Integer id);
    void save(Blog blog);
    void update(Blog blog);
    void delete(Integer id);
}
