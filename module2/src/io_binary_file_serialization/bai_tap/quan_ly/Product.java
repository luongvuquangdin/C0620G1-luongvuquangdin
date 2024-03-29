package io_binary_file_serialization.bai_tap.quan_ly;

import java.io.Serializable;
import java.util.Scanner;

public class Product implements Serializable {
    private int id;
    private String name;
    private String manufacturer;
    private double price;

    public Product(int id, String name, String manufacturer, double price) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public Product() {
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter manufacturer: ");
        manufacturer = scanner.nextLine();
        System.out.print("Enter price: ");
        price = scanner.nextDouble();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                '}';
    }

}
