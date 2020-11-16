package com.end.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class TypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idTypeProduct;
    String nameTypeProduct;

    @OneToMany(mappedBy = "typeProduct",cascade = CascadeType.ALL)
    List<Product> productList;



    public TypeProduct() {
    }

    public Integer getIdTypeProduct() {
        return idTypeProduct;
    }

    public void setIdTypeProduct(Integer idTypeProduct) {
        this.idTypeProduct = idTypeProduct;
    }

    public String getNameTypeProduct() {
        return nameTypeProduct;
    }

    public void setNameTypeProduct(String nameTypeProduct) {
        this.nameTypeProduct = nameTypeProduct;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
