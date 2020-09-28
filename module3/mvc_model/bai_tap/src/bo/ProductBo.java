package bo;

import model.Product;

import java.util.List;

public interface ProductBo {
    List<Product> findAll();
    void create();
    Product findProductByName(String name);
    void update(Integer id);
    void delete(Integer id);
}
