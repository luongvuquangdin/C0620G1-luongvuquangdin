package dao;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void create();
    Product findProductByName(String name);
    void update(Integer id);
    void delete(Integer id);

}
