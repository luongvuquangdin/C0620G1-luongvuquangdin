package com.ajax.controler;

import com.ajax.entity.Category;
import com.ajax.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/")
    public String goHome(Model model){
        model.addAttribute("listCategory",this.categoryService.findAll());
        return "management-category/home";
    }

    @GetMapping("/management_category")
    public String goViewManagement(Model model){
        model.addAttribute("listCategory",this.categoryService.findAll());
        return "management-category/view-management";
    }

    @GetMapping("/create")
    public String goCreate(Model model){
        model.addAttribute("category",new Category());
        return "management-category/create";
    }

    @GetMapping("/back")
    public String back(){
        return "redirect:/";
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute Category category){
        this.categoryService.save(category);
        return "redirect:/management_category";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id){
        this.categoryService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String goEditCustomer(@RequestParam Integer id, Model model){
        model.addAttribute("Category",this.categoryService.findById(id));
        return "management-category/edit";
    }

    @PostMapping("/edit")
    public String EditCustomer(@ModelAttribute Category category){
        this.categoryService.update(category);
        return "redirect:/";
    }
}
