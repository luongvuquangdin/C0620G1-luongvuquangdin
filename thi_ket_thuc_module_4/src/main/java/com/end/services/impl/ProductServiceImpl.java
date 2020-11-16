package com.end.services.impl;

import com.end.entity.Product;
import com.end.entity.TypeProduct;
import com.end.repository.ProductRepository;
import com.end.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return this.productRepository.findAll(pageable);
    }

    @Override
    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public void deleteById(Integer idProduct) {
        this.productRepository.deleteById(idProduct);
    }

    @Override
    public Page<Product> findAllByNameContains(String name, Pageable pageable) {
        return this.productRepository.findAllByNameContains(name,pageable);
    }

    @Override
    public Page<Product> findAllByPriceContaining(Double price, Pageable pageable) {
        return this.productRepository.findAllByPriceContaining(price,pageable);
    }

    @Override
    public Page<Product> findAllByNameContainsAndPriceContaining(String name, Double price, Pageable pageable) {
        return this.productRepository.findAllByNameContainsAndPriceContaining(name,price,pageable);
    }

    @Override
    public Page<Product> searchAllByNameContainsAndPriceContainsAndPriceContaining(String name, String price, String typeProduct, Pageable pageable) {
        return this.productRepository.searchAllByNameContainsAndPriceContainsAndPriceContaining(name,price,typeProduct,pageable);
    }
}
