package com.learning.springboot_dockerize.controller;

import com.learning.springboot_dockerize.entity.Product;
import com.learning.springboot_dockerize.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public Product saveProductDetails (@RequestBody Product product) {

        return productService.saveProduct(product);
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts () {

        return productService.getAllProducts();
    }
}
