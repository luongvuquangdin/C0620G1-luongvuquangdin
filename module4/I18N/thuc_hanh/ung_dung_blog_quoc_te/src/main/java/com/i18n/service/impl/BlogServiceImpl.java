package com.i18n.service.impl;

import com.i18n.entity.Blog;
import com.i18n.repository.BlogRepository;
import com.i18n.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.blogRepository.findAll(pageable);
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

    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public List<Blog> findAllByCategory_NameCategory(String name){
        List<Blog> blogs = this.blogRepository.findAllByCategory_NameCategory(name);
        return blogs;
    }

    @Override
    public List<Blog> displayListBlog(int offset) {
        return this.blogRepository.displayListBlog(offset);
    }
}
