package com.end.services;

import com.end.entity.Product;
import com.end.entity.TypeProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);
    Product save(Product product);
    void deleteById(Integer idProduct);
    Page<Product> findAllByNameContains(String name, Pageable pageable);
    Page<Product> findAllByPriceContaining (Double price,Pageable pageable);
    Page<Product> findAllByNameContainsAndPriceContaining (String name,Double price,Pageable pageable);
    Page<Product> searchAllByNameContainsAndPriceContainsAndPriceContaining (String name, String price,
                                                                           String typeProduct, Pageable pageable);


}
