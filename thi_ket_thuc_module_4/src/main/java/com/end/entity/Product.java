package com.end.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @NotBlank(message = "Name can not left blank")
    @Size(min = 5, max = 50,message = "Name have length form 5 to 50 character")
    String name;
    @NotNull(message = "price can not left blank")
    @Min(value = 10000, message = "Price minimum is 100000 VND")
    Double price;

    @NotBlank(message = "status can not left blank")
    String status;

    @ManyToOne
    @JoinColumn(name = "id_type_product", referencedColumnName = "idTypeProduct")
    TypeProduct typeProduct;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }
}
