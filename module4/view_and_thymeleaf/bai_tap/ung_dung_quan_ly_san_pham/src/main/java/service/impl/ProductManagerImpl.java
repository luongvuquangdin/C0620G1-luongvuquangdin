package service.impl;

import entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductManagerImpl implements ProductManager {
    private static Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "Fridge", "10", "12"));
        products.put(2, new Product(2, "refresher", "20", "13"));
        products.put(3, new Product(3, "Fan", "30", "14"));
        products.put(4, new Product(4, "Television", "40", "10"));
        products.put(5, new Product(5, "Phone", "50", "13"));
        products.put(6, new Product(6, "Washing machine", "60", "13"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product customer) {

        products.put(customer.getId(), customer);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product customer) {
        products.put(id, customer);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
