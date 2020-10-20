package service.impl;

import entity.Product;

import java.util.List;

public interface ProductManager {
    List<Product> findAll();

    void save(Product customer);

    Product findById(int id);

    void update(int id, Product customer);

    void remove(int id);
}
