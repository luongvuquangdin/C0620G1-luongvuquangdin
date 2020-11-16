package com.end.controller;

import com.end.entity.Product;
import com.end.services.ProductService;
import com.end.services.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    TypeProductService typeProductService;

    @GetMapping("/")
    public String goHome(@PageableDefault(size = 1) Pageable pageable, @RequestParam Optional<String> nameProduct,
                         @RequestParam Optional<String> priceProduct,@RequestParam Optional<String> typeProduct,Model model){
        String nameProduct1="";
        String priceProduct1="";
        String typeProduct1="";
        if (nameProduct.isPresent()&&priceProduct.isPresent()&&typeProduct.isPresent()){
            nameProduct1=nameProduct.get();
            priceProduct1=priceProduct.get();
            typeProduct1=typeProduct.get();
            model.addAttribute("listProduct",
                    this.productService.searchAllByNameContainsAndPriceContainsAndPriceContaining(nameProduct1,
                            priceProduct1,typeProduct1,pageable));
        }else model.addAttribute("listProduct",this.productService.findAll(pageable));
        model.addAttribute("nameProduct",nameProduct1);
        model.addAttribute("priceProduct",priceProduct1);
        model.addAttribute("typeProduct",typeProduct1);
        model.addAttribute("listType",this.typeProductService.findAll());
        return "display_product";
    }

    @GetMapping("/create")
    public String goCreate(Model model){
        model.addAttribute("listType",this.typeProductService.findAll());
        model.addAttribute("product",new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute Product product, BindingResult bindingResult,Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("product",product);
            model.addAttribute("listType",this.typeProductService.findAll());
            return "create";
        }
        this.productService.save(product);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Optional<Integer[]> checkQuery) {
        Integer[] checkQuery1;
        if (checkQuery.isPresent()) {
            checkQuery1=checkQuery.get();
            for (int i = 0; i < checkQuery1.length; i++) {
                this.productService.deleteById(checkQuery1[i]);
            }
        }
        return "redirect:/";
    }
}
