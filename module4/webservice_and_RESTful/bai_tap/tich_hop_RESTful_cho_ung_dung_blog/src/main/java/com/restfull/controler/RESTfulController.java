package com.restfull.controler;

import com.restfull.entity.Blog;
import com.restfull.entity.Category;
import com.restfull.service.BlogService;
import com.restfull.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RESTfulController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogService blogService;

    @GetMapping(value = "/list/category")
    public ResponseEntity<List<Category>> viewListCategory(){
        return new ResponseEntity<>(this.categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/list/blog")
    public ResponseEntity<List<Blog>> viewListBlog(){
        return new ResponseEntity<>(this.blogService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/list/blog_of_category/{id}")
    public ResponseEntity<List<Blog>> viewBlogOfCategory(@PathVariable Integer id){
        return new ResponseEntity<>(this.categoryService.findById(id).getBlogList(),HttpStatus.OK);
    }

    @GetMapping("/list/blog/{idBlog}")
    public ResponseEntity<Blog> viewBlog(@PathVariable Integer idBlog){
        return new ResponseEntity<>(this.blogService.findById(idBlog),HttpStatus.OK);
    }
}
