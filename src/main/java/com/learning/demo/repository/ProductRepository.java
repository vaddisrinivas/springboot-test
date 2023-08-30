package com.learning.demo.repository;


import com.learning.demo.entity.Product;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface ProductRepository extends Repository<Product, Long> {

    public Product getProductById(Long id);

    public List<Product> findProductByIdIsNotNull();


    public List<Product> findProductByNameIsContainingIgnoreCase(String name);

    public List<Product> findProductByDescriptionContainingIgnoreCase(String description);

    Product save(Product product);

    Long deleteById(Long id);

    Long deleteByNameIgnoreCase(String name);
}
