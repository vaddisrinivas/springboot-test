package com.learning.demo.Service;


import com.learning.demo.entity.Product;
import com.learning.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getProducts() {
        return productRepository.findProductByIdIsNotNull();
    }
    public Product getProductById(Long id){
        return  productRepository.getProductById(id);
    }
    public List<Product> getProductsByName(String name) {
        return productRepository.findProductByNameIsContainingIgnoreCase(name);
    }

    public List<Product> getProductsByDescription(String name) {
        return productRepository.findProductByDescriptionContainingIgnoreCase(name);
    }
    public Long setProduct(Product product) {
        Product newProduct = productRepository.save(product);
        return newProduct.getId();
    }

    public Long deleteProduct(Long id) {
        return productRepository.deleteById(id);
    }
}
