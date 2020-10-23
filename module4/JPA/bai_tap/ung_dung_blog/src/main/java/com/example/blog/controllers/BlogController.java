package com.example.blog.controllers;

import com.example.blog.entity.Blog;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public ModelAndView goView(){
        ModelAndView modelAndView=new ModelAndView("view");
        modelAndView.addObject("listBlog",this.blogService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public String goCreate(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @GetMapping("/back")
    public  String goBack(){
        return "redirect:/";
    }

    @PostMapping("/create")
    public String createNew(@ModelAttribute Blog blog){
        this.blogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        this.blogService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String goEditCustomer(@RequestParam Integer id, Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String EditCustomer(@ModelAttribute Blog blog){
        this.blogService.update(blog);
        return "redirect:/";
    }

    @GetMapping("info")
    public String infoBlog(@RequestParam Integer id,Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "read-blog";
    }
}
