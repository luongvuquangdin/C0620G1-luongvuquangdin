package com.end.repository;

import com.end.entity.Product;
import com.end.entity.TypeProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findAllByNameContains(String name, Pageable pageable);
    Page<Product> findAllByPriceContaining (Double price,Pageable pageable);
    Page<Product> findAllByNameContainsAndPriceContaining (String name,Double price,Pageable pageable);

    @Query(value = "select * from product where `name` like %?1% and price like %?2% and id_type_product like %?3%",
            nativeQuery = true)
    Page<Product> searchAllByNameContainsAndPriceContainsAndPriceContaining (String name,String price,
                                                                           String typeProduct,Pageable pageable);

}
