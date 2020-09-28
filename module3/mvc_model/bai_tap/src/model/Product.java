package model;

public class Product {
    int id;
    String name;
    Double price;
    String description;
    String productManufacturer;

    public Product(int id, String name, Double price, String productManufacturer, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.productManufacturer = productManufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }
}
