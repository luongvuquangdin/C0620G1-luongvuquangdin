package com.security.controler;

import com.security.entity.AppRole;
import com.security.entity.AppUser;
import com.security.entity.Category;
import com.security.entity.UserRole;
import com.security.service.AppRoleService;
import com.security.service.AppUserService;
import com.security.service.CategoryService;
import com.security.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    AppUserService appUserService;

    @Autowired
    AppRoleService appRoleService;

    @Autowired
    UserRoleService userRoleService;

    @GetMapping("/")
    public String goToHome(){
        return "welcome";
    }

    @GetMapping("/registration")
    public String goRegistrationUser(Model model){
        model.addAttribute("user",new AppUser());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationUser(@ModelAttribute AppUser appUser,@RequestParam Long[] role) {
        BCryptPasswordEncoder encode=new BCryptPasswordEncoder();
        String pass=encode.encode(appUser.getEncrytedPassword());
        appUser.setEncrytedPassword(pass);
        this.appUserService.save(appUser);
        AppUser appUser1=this.appUserService.findByUserName(appUser.getUserName());
        for (int i=0;i<role.length;i++){
            this.userRoleService.save(appUser1,role[i].longValue());
        }
        return "welcome";
    }
    @GetMapping("/list")
    public String goHome(Model model){
        model.addAttribute("listCategory",this.categoryService.findAll());
        return "management-category/home";
    }

    @GetMapping("/login")
    public String goLogin(){
        return "login";
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
        return "redirect:/list";
    }

    @GetMapping("/edit")
    public String goEditCustomer(@RequestParam Integer id, Model model){
        model.addAttribute("Category",this.categoryService.findById(id));
        return "management-category/edit";
    }

    @PostMapping("/edit")
    public String EditCustomer(@ModelAttribute Category category){
        this.categoryService.update(category);
        return "redirect:/list";
    }

    @GetMapping("/403")
    public String goError(){
        return "403";
    }

    @GetMapping("/exit")
    public String backWelcome(){
        return "redirect:/";
    }
}
