package com.blog.blog.controler;

import com.blog.blog.entity.Blog;
import com.blog.blog.service.BlogService;
import com.blog.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;


@Controller
@RequestMapping("/blog")
public class BlogController {
   @Autowired
   BlogService blogService;

   @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public ModelAndView goView(@RequestParam Integer id){
        ModelAndView modelAndView=new ModelAndView("management-blog/view");
        modelAndView.addObject("listBlog",this.categoryService.findById(id).getBlogList());
        return modelAndView;
    }

    @GetMapping("/create")
    public String goCreate(Model model){
        model.addAttribute("listCategory",this.categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "management-blog/create";
    }

    @GetMapping("/back")
    public  String goBack(){
        return "redirect:/";
    }

    @PostMapping("/create")
    public String createNew(@ModelAttribute Blog blog){
        java.util.Date dateUnit=new java.util.Date();
        Date date=new Date(dateUnit.getYear(),dateUnit.getMonth(),dateUnit.getDay());
        blog.setDate(date);

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
        model.addAttribute("listCategory",this.categoryService.findAll());
        return "management-blog/edit";
    }

    @PostMapping("/edit")
    public String EditCustomer(@ModelAttribute Blog blog){
        java.util.Date dateUtil=new java.util.Date();
        Date date=new Date(dateUtil.getYear(),dateUtil.getMonth(),dateUtil.getDay());
        blog.setDate(date);
        this.blogService.update(blog);
        return "redirect:/";
    }

    @GetMapping("/info")
    public String infoBlog(@RequestParam Integer id,Model model){
        model.addAttribute("blog",this.blogService.findById(id));
        return "management-blog/read-blog";
    }
}
