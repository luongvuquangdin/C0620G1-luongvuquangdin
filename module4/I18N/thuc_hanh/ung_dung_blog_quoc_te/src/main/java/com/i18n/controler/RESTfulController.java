package com.i18n.controler;

import com.i18n.entity.Blog;
import com.i18n.entity.Category;
import com.i18n.service.BlogService;
import com.i18n.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
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
        return new ResponseEntity<>(this.blogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/list/blog_of_category/{id}")
    public ResponseEntity<List<Blog>> viewBlogOfCategory(@PathVariable Integer id){
        return new ResponseEntity<>(this.categoryService.findById(id).getBlogList(), HttpStatus.OK);
    }

    @GetMapping("/list/blog/{ida}")
    public ResponseEntity<Blog> viewBlog(@PathVariable Integer ida){
        return new ResponseEntity<>(this.blogService.findById(ida), HttpStatus.OK);
    }

    @GetMapping("/search_list_blog/{name}")
    public ResponseEntity<List<Blog>> search(@PathVariable String name){
        return new ResponseEntity<>(this.blogService.findAllByCategory_NameCategory(name), HttpStatus.OK);
    }

    @GetMapping("/list_scroll/{offset}")
    public ResponseEntity<List<Blog>> viewListScroll(@PathVariable int offset){
        return new ResponseEntity<>(this.blogService.displayListBlog(offset), HttpStatus.OK);
    }
}
