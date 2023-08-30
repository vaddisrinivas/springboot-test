package com.learning.demo.controller;

import com.learning.demo.Service.ProductService;
import com.learning.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    public ProductService productService;
    @Autowired
    private Environment environment;
    @GetMapping(value = "/product",name = "product")
    public Product getProductById(@RequestParam Long id){
        return productService.getProductById(id);
    }

    @GetMapping(value = "/env",name = "env")
    public String[] getEnvironment(){
        return environment.getActiveProfiles();
    }
    @GetMapping(value = "/products",name = "products")
    public List<Product> getProducts(@RequestParam(required = false) String name, @RequestParam(required = false) String description){
        if (name!=null) {
            return productService.getProductsByName(name);
        } else if (description!=null) {
            return productService.getProductsByDescription(name);
        } else {
            return productService.getProducts();
        }
    }

    @PostMapping(value = "/products",name = "products")
    public Long setProduct(@RequestBody Product product){
        return productService.setProduct(product);
    }

    @DeleteMapping(value = "/products", name = "products")
    public Long deleteProduct(@RequestParam Long id){
        return productService.deleteProduct(id);
    }

}
