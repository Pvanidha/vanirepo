package com.learning.springboot_dockerize.repository;

import com.learning.springboot_dockerize.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
