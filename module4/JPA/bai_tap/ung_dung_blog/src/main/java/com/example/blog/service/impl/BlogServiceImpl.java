package com.example.blog.service.impl;

import com.example.blog.entity.Blog;
import com.example.blog.repository.BlogRepository;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return this.blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog customer) {
        this.blogRepository.save(customer);
    }

    @Override
    public void update(Blog customer) {
        this.blogRepository.save(customer);
    }

    @Override
    public void delete(Integer id) {
        this.blogRepository.deleteById(id);
    }
}