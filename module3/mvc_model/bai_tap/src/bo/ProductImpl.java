package bo;

import dao.ProductService;
import dao.ProductServiceImpl;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements ProductBo {
    ProductService productService=new ProductServiceImpl();
    @Override
    public List<Product> findAll() {
        return this.productService.findAll();
    }

    @Override
    public void create() {

    }

    @Override
    public Product findProductByName(String name) {
        return null;
    }

    @Override
    public void update(Integer id) {

    }

    @Override
    public void delete(Integer id) {

    }
}
