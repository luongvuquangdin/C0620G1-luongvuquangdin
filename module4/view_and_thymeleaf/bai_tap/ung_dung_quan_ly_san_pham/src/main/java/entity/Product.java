package entity;

public class Product {
    private int id;
    private String name;
    private String price;
    private String status;

    public Product() {
    }

    public Product(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.price = email;
        this.status = address;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
