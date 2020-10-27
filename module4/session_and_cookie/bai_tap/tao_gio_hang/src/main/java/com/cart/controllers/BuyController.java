package com.cart.controllers;

import com.cart.entity.Product;
import com.cart.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
@SessionAttributes({"user","listBuyProduct"})
public class BuyController {
    @Autowired
    ProductService productService;
    @ModelAttribute("listBuyProduct")
    public List<Product> createCartProduct(){
        return new ArrayList<Product>();
    }
    @GetMapping()
    public String goHome(Model model){
        model.addAttribute("listProduct",this.productService.findAll());
        return "product/home";
    }

    @GetMapping("/view")
    public String goViewProduct(@RequestParam Integer id,Model model){
        model.addAttribute("product",this.productService.findById(id));
        return "product/view";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam Integer id,@ModelAttribute("listBuyProduct") List<Product> listBuyProduct){
        listBuyProduct.add(this.productService.findById(id));
        return "redirect:/home";
    }

    @GetMapping("/cart")
    public String goCart(@ModelAttribute("listBuyProduct") List<Product> listBuyProduct,Model model){
        model.addAttribute("listBuyProduct",listBuyProduct);
        return "product/view_cart";
    }

    @GetMapping("/delete")
    public ModelAndView deleteProductInCart(@RequestParam Integer id, @ModelAttribute("listBuyProduct") List<Product> listBuyProduct){
        ModelAndView modelAndView=new ModelAndView("product/view_cart");
        Product product=this.productService.findById(id);
        for (Product productTemp:listBuyProduct){
            if (productTemp.getIdProduct()==product.getIdProduct()){
                listBuyProduct.remove(productTemp);
                break;
            }
        }
        modelAndView.addObject("listBuyProduct",listBuyProduct);
        return modelAndView;
    }

}
